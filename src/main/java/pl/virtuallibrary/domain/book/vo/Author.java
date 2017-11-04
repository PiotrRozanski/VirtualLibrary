package pl.virtuallibrary.domain.book.vo;

import org.apache.commons.lang3.StringUtils;
import pl.virtuallibrary.domain.book.exception.BookInformationException;

public class Author {

    private final String value;

    public Author(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) {
            throw new BookInformationException("No book author");
        }
        if(StringUtils.isNumeric(value)) {
            throw new BookInformationException("Bad format book author: " + value);
        }
    }

    public String getValue() {
        return value;
    }
}
