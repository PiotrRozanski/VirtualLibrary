package pl.virtuallibrary.repository.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.virtuallibrary.application.EbookInformationCommand;

public interface BookCompleteInformationRepository extends MongoRepository<EbookInformationCommand, String>{
}
