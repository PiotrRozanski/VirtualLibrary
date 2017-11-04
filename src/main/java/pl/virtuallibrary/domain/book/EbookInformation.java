package pl.virtuallibrary.domain.book;

import pl.virtuallibrary.domain.book.vo.*;

import java.util.List;
import java.util.stream.Collectors;

public class EbookInformation {

    private final Title title;
    private final List<Author> authors;
    private final PublishedDate publishedDate;
    private final Description description;
    private final ISBN isbn;
    private final PageCount pageCount;
    private final ImageURL imageURL;

    public EbookInformation(final Title title,
                            final List<Author> authors,
                            final PublishedDate publishedDate,
                            final Description description,
                            final ISBN isbn,
                            final PageCount pageCount,
                            final ImageURL imageURL) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.description = description;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.imageURL = imageURL;
    }

    public Title getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors.stream().map(Author::getValue).collect(Collectors.toList());
    }

    public PublishedDate getPublishedDate() {
        return publishedDate;
    }

    public Description getDescription() {
        return description;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public PageCount getPageCount() {
        return pageCount;
    }

    public ImageURL getImageURL() {
        return imageURL;
    }
}
