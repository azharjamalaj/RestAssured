package restfulBooker.postRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateMethodInBDDFormat {
	@Test
	public void createPostRequestInBddFormat()
	{
//		Given - Build Request (Constructing the request- Precondition) 
		RestAssured.
			given().
					log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking").body("{\r\n" + 
					"    \"firstname\" : \"Azhar\",\r\n" + 
					"    \"lastname\" : \"Jamal\",\r\n" + 
					"    \"totalprice\" : 1111,\r\n" + 
					"    \"depositpaid\" : true,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2022-12-29\",\r\n" + 
					"        \"checkout\" : \"2023-01-01\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
					"}").contentType(ContentType.JSON).
//		When - Set of action performed 
			when().
					post().
//		Then - is the outcome(Validate the output)
			then().statusCode(200).log().all();		
	}

}
