package pl.virtuallibrary.repository.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.virtuallibrary.domain.book.Ebook;

public interface BookInformationRepository extends MongoRepository<Ebook, String> {
}
