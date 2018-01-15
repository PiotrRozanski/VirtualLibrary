package pl.virtuallibrary.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.virtuallibrary.application.EbookInformationCommand;
import pl.virtuallibrary.rest.request.BookInformationRequest;
import pl.virtuallibrary.service.GoogleService;

import java.util.List;

@RestController
@RequestMapping("/google")
@CrossOrigin("*")
@Api(value = "Google Books", description = "The operations getting the details of books")
public class GoogleBooksController {

    private final GoogleService googleService;
    private final Logger logger;

    public GoogleBooksController(final GoogleService googleService) {
        this.googleService = googleService;
        this.logger = LoggerFactory.getLogger(GoogleBooksController.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "book/details", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved details of book"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public void getBookDetails(@RequestBody final BookInformationRequest information) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "books/download/details", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully downloaded details of books"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public void downloadBooksDetails() {
        googleService.downloadBooksInformations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "books/details", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved details of books"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<EbookInformationCommand> getBooksDetails() {
        return googleService.getBooksInformations();
    }

}
