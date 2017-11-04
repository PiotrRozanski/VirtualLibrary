package pl.virtuallibrary.google.books.api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volumes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.virtuallibrary.google.books.api.exception.GoogleException;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Component
public class GoogleConnection {

    private static final String APPLICATION_NAME = "VirtualLibrary";
    private static final String API_KEY = "AIzaSyCmxSJCsgdh-riVCOznDpdFKUiKVpeHEU0";

    private final Logger logger;
    private final JsonFactory jsonFactory;
    private final Books booksClient;

    public GoogleConnection() {
        this.logger = LoggerFactory.getLogger(GoogleConnection.class);
        this.jsonFactory = JacksonFactory.getDefaultInstance();
        this.booksClient = setUpBooksClient(jsonFactory);
    }

    private Books setUpBooksClient(final JsonFactory jsonFactory) {
        try {
            return new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName(APPLICATION_NAME)
                .setGoogleClientRequestInitializer(new BooksRequestInitializer(API_KEY))
                .build();
        } catch (GeneralSecurityException | IOException exception) {
            throw new GoogleException("Google connection error: ", exception);
        }
    }

    public Volumes execute(final String title) {
        try {
            return booksClient.volumes()
                              .list("")
                              .setQ("intitle:" + title)
                              .execute();
        } catch (IOException exception) {
            throw new GoogleException("Books not found: ", exception);
        }
    }
}
