package pl.virtuallibrary.cucumber.stepdefs;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class StepDefs {

    private final String GET_BOOKS_DETAILS_URL = "http://localhost:8080/virtuallibrary/google/books/details";

    private Response response;

    @Given("^Użytkownik posiada następujące książki:$")
    public void użytkownikPosiadaNastępująceKsiążki(final Map<String, String> bookInfo) {
        System.out.println(bookInfo);
    }

    @When("^Użytkownik pobierze szegółowe informacje o posiadanych książkach$")
    public void użytkownikPobierzeSzegółoweInformacjeOPosiadanychKsiążkach() {
        response = given().when().get(GET_BOOKS_DETAILS_URL);
    }

    @Then("^Otrzyma następujące informacje:$")
    public void otrzymaNastępująceInformacje(final Map<String, String> info) {
        response.then().body("title", hasItem(info.get("title")))
                       .body("find { it.title=='" + info.get("title") + "'}.authors", hasItem(info.get("authors")))
                       .body("pageCount", hasItem(Integer.valueOf(info.get("pageCount"))))
                       .body("publishedDate", hasItem(info.get("publishedDate")));
    }

}
