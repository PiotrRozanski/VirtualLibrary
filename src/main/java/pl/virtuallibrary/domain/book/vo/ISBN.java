package pl.virtuallibrary.domain.book.vo;

import org.apache.commons.lang3.StringUtils;
import pl.virtuallibrary.domain.book.exception.BookInformationException;

public class ISBN {
    private static final String ISBN_PATTERN = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";

    private final String type;
    private final String identifier;

    public ISBN(final String type,
                final String identifier) {
        validate(type, identifier);
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    private void validate(final String type,
                          final String identifier) {
        if(StringUtils.isEmpty(identifier) || StringUtils.isBlank(identifier)) {
            throw new BookInformationException("No book isbn");
        }
        if(!isISBNNumber(identifier)){
            throw new BookInformationException("Bad format isbn: " + identifier);
        }
        if(StringUtils.isEmpty(type) || StringUtils.isBlank(type)) {
            throw new BookInformationException("No book type");
        }
        if(!type.equals("ISBN_10") && !type.equals("ISBN_13")) {
            throw new BookInformationException("Bad type type: " + type);
        }
    }

    private Boolean isISBNNumber(final String value) {
        return value.matches(ISBN_PATTERN);
    }
}
