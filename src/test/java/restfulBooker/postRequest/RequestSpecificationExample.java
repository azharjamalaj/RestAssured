package restfulBooker.postRequest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.http.ContentType;
public class RequestSpecificationExample {

	io.restassured.specification.RequestSpecification requestSpecification;
	
	@BeforeClass
	public void setupSpecification()
	{
		requestSpecification= RestAssured.given().log().all().
				baseUri("https://restful-booker.herokuapp.com/");
				
	}
	@Test
	public void requestSpecificationCreateBooking()
	{
		RestAssured.given().spec(requestSpecification).basePath("{basePath}").
		pathParam("basePath", "booking")
		.body("{\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}")
		.contentType(ContentType.JSON)
		.when().post().then().extract().body().asPrettyString();
	}
	
	@Test(dependsOnMethods="requestSpecificationCreateBooking")
	public void requestSpecificationUpdateBooking()
	{
		Map<String, Object> pathParmeter= new HashMap<String, Object>();
		pathParmeter.put("basepath", "booking");
		pathParmeter.put("bookingID", 2641);
		RestAssured.given().spec(requestSpecification).
				 basePath("{basepath}/{bookingID}")
				.pathParams(pathParmeter)
				.header("Content-Type", "application/json")
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body("{\r\n" + 
						"    \"firstname\" : \"Nadia\",\r\n" + 
						"    \"lastname\" : \"Brown\",\r\n" + 
						"    \"totalprice\" : 111,\r\n" + 
						"    \"depositpaid\" : true,\r\n" + 
						"    \"bookingdates\" : {\r\n" + 
						"        \"checkin\" : \"2018-01-01\",\r\n" + 
						"        \"checkout\" : \"2019-01-01\"\r\n" + 
						"    },\r\n" + 
						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
						"}")
			.when()
				.put().then().log().all().statusCode(200);
		//Here we have static ID. In real time automation we have dynamic ID 
	}
}
