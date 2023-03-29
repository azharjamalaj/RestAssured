package restfulBooker.postRequest;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MeasureTimeExample {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeTest
	public void specifications()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		RestAssured.basePath="booking";
		requestSpecification= RestAssured.given().log().all();
		responseSpecification=RestAssured.expect().contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(5000L));
		
	}
	@Test(groups="CreateBooking")
	public void createBooking()
	{
		Response response =RestAssured.given(requestSpecification)
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
				"}").contentType(ContentType.JSON).when().post();
		
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.time());
		System.out.println(response.timeIn(TimeUnit.SECONDS));
		System.out.println(response.then().time(Matchers.lessThan(5000L)));
		System.out.println(response.then().time(Matchers.greaterThan(1000L)));
		System.out.println(response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(1000L))));
		
	}

	@Test
	public void createBooking2()
	{
		System.out.println("Don't run this tc");
		Response response =RestAssured.given(requestSpecification)
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
				"}").contentType(ContentType.JSON).when().post();
		
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.time());
		System.out.println(response.timeIn(TimeUnit.SECONDS));
		System.out.println(response.then().time(Matchers.lessThan(5000L)));
		System.out.println(response.then().time(Matchers.greaterThan(1000L)));
		System.out.println(response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(1000L))));
		
	}
}
