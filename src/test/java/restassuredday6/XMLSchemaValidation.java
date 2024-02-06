package restassuredday6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {

	@Test
	public void xmlSchemaValidation() {
		/*
		 * Json Response (.json) ---> Json schema (.json)
		 * XML Response (.xml) · ---> xml schema (.xsd)
		 * https://www.liquid-technologies.com/online-xml-to-xsd-converter
		 * */
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
	}
}
