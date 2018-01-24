package pl.virtuallibrary.domain.book.vo;

import pl.virtuallibrary.domain.book.exception.BookInformationException;

public class PageCount {

    private final int value;

    public PageCount(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if(value < 0) {
            throw new BookInformationException("Page count must be bigger than 0: " + value);
        }
    }

    public int getValue() {
        return value;
    }
}
