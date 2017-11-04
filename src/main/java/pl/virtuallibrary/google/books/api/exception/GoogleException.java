package pl.virtuallibrary.google.books.api.exception;

public class GoogleException extends RuntimeException {

    public GoogleException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
