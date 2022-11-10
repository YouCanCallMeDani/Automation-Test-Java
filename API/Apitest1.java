package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Apitest1 {

    @Test
    public void pagination20() {
        given().
                when().
                get("https://api.punkapi.com/v2/beers?page=2&per_page=20").
                then().
                assertThat().
                log().ifValidationFails().
                statusCode(200);
    }

    @Test
    public void pagination5() {
        given().
                when().
                get("https://api.punkapi.com/v2/beers?page=2&per_page=5").
                then().
                assertThat().
                log().ifValidationFails().
                statusCode(200);
    }

    @Test
    public void pagination1() {
        given().
                when().
                get("https://api.punkapi.com/v2/beers?page=2&per_page=1").
                then().
                assertThat().
                log().ifValidationFails().
                statusCode(200);
    }
}