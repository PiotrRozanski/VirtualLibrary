package pl.virtuallibrary.application;

import pl.virtuallibrary.domain.book.EbookInformation;
import pl.virtuallibrary.domain.book.vo.ISBN;

import java.util.List;

public class EbookInformationCommand {

    private final String title;
    private final List<String> authors;
    private final String publishedDate;
    private final String description;
    private final ISBN isbn;
    private final int pageCount;
    private final String imageURL;

    public EbookInformationCommand(final EbookInformation info) {
        this.title = info.getTitle().getValue();
        this.authors = info.getAuthors();
        this.publishedDate = info.getPublishedDate().getValue();
        this.description = info.getDescription().getValue();
        this.isbn = info.getIsbn();
        this.pageCount = info.getPageCount().getValue();
        this.imageURL = info.getImageURL().getValue();
    }
}
