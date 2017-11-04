package pl.virtuallibrary.domain.book.vo;

import org.apache.commons.lang3.StringUtils;
import pl.virtuallibrary.domain.book.exception.BookInformationException;

public class ImageURL {
    private final static String WEBSITE_URL_PATTERN = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";

    private final String value;

    public ImageURL(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if(StringUtils.isBlank(value) || StringUtils.isEmpty(value)) {
            throw new BookInformationException("No book image URL");
        }
        if(isWebAddress(value)) {
            throw new BookInformationException("Bad format website URL: " + value);
        }
    }

    private Boolean isWebAddress(final String value) {
        return value.matches(WEBSITE_URL_PATTERN);
    }

    public String getValue() {
        return value;
    }
}
