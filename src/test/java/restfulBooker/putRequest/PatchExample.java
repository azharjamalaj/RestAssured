package restfulBooker.putRequest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PatchExample {
	
@Test
public void patchExample1() 
{
	Map<String, Object> pathParameter= new HashMap<String, Object>();
	pathParameter.put("basepath","booking");
	pathParameter.put("bookingID", 1);
	RestAssured.given().log().all().
	baseUri("https://restful-booker.herokuapp.com/")
	.basePath("{basepath}/{bookingID}").pathParams(pathParameter).header("Content-Type", "application/json")
	.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
	.body("{\r\n" + 
			"    \"firstname\" : \"James\",\r\n" + 
			"    \"lastname\" : \"Jamal\",\r\n" + 
			"  \"additionalneeds\" : \"Lunch\"\r\n" + 
			"}")
	.when().patch().then().log().all().statusCode(200);
}

}
