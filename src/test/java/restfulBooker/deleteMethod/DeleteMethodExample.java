package restfulBooker.deleteMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteMethodExample {
@Test
public void deleteMethodDemo()
{
	RestAssured.
	given().log().all()
		.baseUri("https://restful-booker.herokuapp.com/").basePath("/booking/{bookingID}")
		.pathParam("bookingID", 5)
		.header("Content-Type", "application/json")
		.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
	when().
		delete().
	then().log().all().statusCode(201);
	}
}
