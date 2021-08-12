package api;

import org.testng.annotations.Test;

import java.util.*;

import static consts.BusinessConfigs.page.HOME_PAGE_API;
import static io.restassured.RestAssured.given;

public class ContactUsTest {

    @Test(description = "Send 'Contact us' message", groups = "APITest")
    public void sendContactUsMessage() {

        Map<String, String> contactUsField = new HashMap<>();
        contactUsField.put("comment", "string");
        contactUsField.put("email", "string");
        contactUsField.put("name", "string");
        contactUsField.put("subject", "string");

        given()
                .contentType("application/json")
                .accept("application/json")
                .body(contactUsField)
                .when()
                .post(HOME_PAGE_API.getUrl() + "/api/v1/contact")
                .then()
                .statusCode(200);
    }
}
