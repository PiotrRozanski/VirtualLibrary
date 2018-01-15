package pl.virtuallibrary.application;

import pl.virtuallibrary.domain.book.vo.ISBN;

import java.util.List;

public class EbookInformationCommand {

    private final String title;
    private final List<String> authors;
    private final String publishedDate;
    private final String description;
    private final ISBN isbn;
    private final int pageCount;
    private final String imageURL;

    public EbookInformationCommand(final String title,
                                   final List<String> authors,
                                   final String publishedDate,
                                   final String description,
                                   final ISBN isbn,
                                   final int pageCount,
                                   final String imageURL) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.description = description;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getImageURL() {
        return imageURL;
    }
}
