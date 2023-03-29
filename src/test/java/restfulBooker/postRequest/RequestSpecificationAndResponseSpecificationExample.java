package restfulBooker.postRequest;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationAndResponseSpecificationExample {
	
	/*RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void specifications()
	{
		requestSpecification= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking").log().all();
		responseSpecification=RestAssured.expect().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(5000L));
		
	}*/
	
	@Test(groups="CreateBooking")
	public void createBooking()
	{
		RestAssured.given()
		//.spec(requestSpecification).
		.body("{\r\n" + 
				"    \"firstname\" : \"Azhar\",\r\n" + 
				"    \"lastname\" : \"Jamal\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}").contentType(ContentType.JSON).when().post().then().log().all();
		System.out.println("Here in Request & Response specification class");
	}
}
