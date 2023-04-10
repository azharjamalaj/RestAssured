package restfulBooker.jsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class JsonInLineAssertionWithArray {
    @Test
    public void inLineAssertionExample()
    {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking")
                .when().get().then().log().all().body("bookingid",Matchers.hasItems(5950));
                ;
    }

}
