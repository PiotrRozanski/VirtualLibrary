package pl.virtuallibrary.contracts;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.virtuallibrary.rest.controller.GoogleBooksController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoogleBooksController.class)
public class ContractsConfig {

    @Autowired
    private GoogleBooksController googleBooksController;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(googleBooksController);
    }
}
