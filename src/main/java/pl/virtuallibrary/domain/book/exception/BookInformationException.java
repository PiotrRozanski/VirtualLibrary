package pl.virtuallibrary.domain.book.exception;

public class BookInformationException extends IllegalArgumentException {

    public BookInformationException(final String message) {
        super(message);
    }
}
