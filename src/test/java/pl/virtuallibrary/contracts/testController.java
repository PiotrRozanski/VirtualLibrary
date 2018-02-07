package pl.virtuallibrary.contracts;

import groovy.transform.builder.Builder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

}

@Builder
class TestDTO {
    private long id;
}
