


package restfulBooker.getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StartWithGetMethod {
	
	@Test
	public void gettingStartedWithGetMethod()
	{
		RequestSpecification requestSpecification= RestAssured.given().log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking/{id}");
		requestSpecification.pathParam("id", "8304");
		
		Response response= requestSpecification.get();
		ValidatableResponse validatableResponse=response.then().log().all();
		validatableResponse.statusCode(200);
	}

}
