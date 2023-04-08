package restfulBooker.postRequest;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateBooking {
	@Test
	public void createBookingWithSteps() {
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		
		requestSpecification.body("{\r\n" + 
				"    \"firstname\" : \"Azhar\",\r\n" + 
				"    \"lastname\" : \"Jamal\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}").contentType(ContentType.JSON);
		Response reponse=requestSpecification.post();
		String responseBody = reponse.asPrettyString();

		JsonPath jsonPath= new JsonPath(responseBody);
		Object obj=jsonPath.get("booking.bookingdates.checkin");
		System.out.println(obj );
		//reponse.then().statusCode(200).log().all();
	}

}
