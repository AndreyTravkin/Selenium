package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestWrapper {

    private String baseUrl = "https://skryabin.com/recruit/api/v1/";
    private static String loginToken;

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public void login(Map<String, String> credentials) {

        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .body(credentials);

        // execute
        Response response = request
                .post(baseUrl + "login");

        // verify and extract
        Map<String, String> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        loginToken = "Bearer " + result.get("token");
    }

    public Map<String, String> createPosition(Map<String, String> position) {

        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(position);

        // execute
        Response response = request
                .post(baseUrl + "positions");

        // verify and extract
        Map<String, String> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

}