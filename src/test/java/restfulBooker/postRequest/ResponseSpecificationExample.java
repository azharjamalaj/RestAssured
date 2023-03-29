package restfulBooker.postRequest;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class ResponseSpecificationExample {
	
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void statusValidation()
	{
	    responseSpecification= RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.statusCode(200);
		responseSpecification.time(Matchers.lessThan(5000L));
		
		
	}
	@Test
	public void createBookingWithSteps() {
		RestAssured.given().
		log().all().
		baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking").
		
		body("{\r\n" + 
				"    \"firstname\" : \"Azhar\",\r\n" + 
				"    \"lastname\" : \"Jamal\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}").contentType(ContentType.JSON).when().post().
		then().log().all().spec(responseSpecification);
	}
}
