package pl.virtuallibrary.domain.book.exception;

public class BookException extends IllegalArgumentException {

    public BookException(final String message) {
        super(message);
    }
}
