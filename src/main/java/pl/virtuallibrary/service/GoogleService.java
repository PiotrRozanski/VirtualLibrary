package pl.virtuallibrary.service;

import com.google.api.services.books.model.Volume;
import org.springframework.stereotype.Service;
import pl.virtuallibrary.application.EbookInformationCommand;
import pl.virtuallibrary.domain.book.Ebook;
import pl.virtuallibrary.google.books.api.GoogleConnection;
import pl.virtuallibrary.google.books.api.mapper.EbookInformationMapper;
import pl.virtuallibrary.repository.jpa.BookCompleteInformationRepository;
import pl.virtuallibrary.repository.jpa.BookInformationRepository;

import java.util.List;

@Service
public class GoogleService {

    private final GoogleConnection connection;
    private final BookInformationRepository informationRepository;
    private final BookCompleteInformationRepository completeInformationRepository;
    private final EbookInformationMapper mapper;

    public GoogleService(final GoogleConnection connection,
                         final BookInformationRepository informationRepository,
                         final BookCompleteInformationRepository completeInformationRepository,
                         final EbookInformationMapper mapper) {
        this.connection = connection;
        this.informationRepository = informationRepository;
        this.completeInformationRepository = completeInformationRepository;
        this.mapper = mapper;
    }

    public void downloadBooksInformations() {
        completeInformationRepository.deleteAll();
        final List<Ebook> booksInformations = informationRepository.findAll();
        for (final Ebook information: booksInformations) {
            final String title = information.getName().replace(".pdf", "");
            final EbookInformationCommand command = mapper.mapToEbookInformation(getDetailedInformationOfBook(title));
            completeInformationRepository.save(command);
        }
    }

    public List<EbookInformationCommand> getBooksInformations() {
        return completeInformationRepository.findAll();

    }

    private Volume getDetailedInformationOfBook(final String title) {
        return connection.execute(title).getItems().get(0);
    }
}
