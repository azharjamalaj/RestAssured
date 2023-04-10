package restfulBooker.jsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class JsonInLineAssertion {
    @Test
    public void inLineAssertionExample()
    {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}").contentType(ContentType.JSON).when().post().then().log().all()
                .body("token", Matchers.notNullValue()).
                body("token.length()",Matchers.equalTo(15))
                .body("token",Matchers.matchesRegex("^[a-z0-9]+$"));
    }

}
