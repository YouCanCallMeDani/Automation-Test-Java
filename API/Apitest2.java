package API;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Apitest2 {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.punkapi.com/v2";
    }
    @Test
    public void checkSchema() {
        given().
                when().
                get("beers").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(200).
                log().body().
                and().
                contentType(ContentType.JSON).
                body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
