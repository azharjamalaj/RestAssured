package restfulBooker.getRequest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathParameterExample {
	@Test
	public void pathParameter() 
	
	{
		Map<String, Object> pathParmeter= new HashMap<String, Object>();
		pathParmeter.put("basepath", "booking");
		pathParmeter.put("bookingID", 1021);
		RestAssured
		.given().log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("{basepath}/{bookingID}")
			.pathParams(pathParmeter)
		.when()
			.get()
		.then()
			.statusCode(200).log().all();
	}

}
