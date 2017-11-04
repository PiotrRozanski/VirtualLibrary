package pl.virtuallibrary.domain.book.vo;

import org.apache.commons.lang3.StringUtils;
import pl.virtuallibrary.domain.book.exception.BookInformationException;

public class PublishedDate {

    private final String value;

    public PublishedDate(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if(StringUtils.isBlank(value) && StringUtils.isEmpty(value)) {
            throw new BookInformationException("No published date: " + value);
        }
    }

    public String getValue() {
        return value;
    }
}
