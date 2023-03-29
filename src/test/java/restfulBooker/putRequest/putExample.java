package restfulBooker.putRequest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class putExample {
@Test
public void putExampleDemo()
{
	Map<String, Object> pathParmeter= new HashMap<String, Object>();
	pathParmeter.put("basepath", "booking");
	pathParmeter.put("bookingID", 2641);
	RestAssured
	.given().log().all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("{basepath}/{bookingID}")
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
