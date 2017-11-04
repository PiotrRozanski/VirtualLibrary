package pl.virtuallibrary.rest.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Basic information about a book")
public class BookInformationRequest {

    @ApiModelProperty(value = "The book title", required = true)
    private String title;

    @ApiModelProperty(value = "The book author", required = true)
    private String author;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

//    public EbookInformation toCommand() {
//        return new EbookInformation(title,author, "das", "asdas", "dasdsa");
//    }
}
