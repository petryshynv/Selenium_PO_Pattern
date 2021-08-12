package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.stream.Collectors;

import static consts.BusinessConfigs.page.*;
import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class ServiceForCombinedApi {
    public List<String> combinedTestApiPart() {
        Response response = RestAssured
                .given()
                .when()
                .get(HOME_PAGE_API.getUrl() + "/services/public/products/page/0/30/DEFAULT/en/beach-bags")
                .then()
                .statusCode(200).extract().response();
        List<String> listOfItemsApi = response.jsonPath().getList("products.description.name");
        List<String> listOfItemsApiToLowerCase = listOfItemsApi.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        LOG.info("List of item names from API are got");
        return listOfItemsApiToLowerCase;
    }
}
