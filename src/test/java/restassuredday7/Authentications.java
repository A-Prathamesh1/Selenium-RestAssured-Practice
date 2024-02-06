package restassuredday7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentications {
	
	@Test(priority = 1)
	public void basicAuthentication() {
		given() //user name postman and password password
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority = 2)
	public void digestAuthentication() {
		given() //user name postman and password password
			.auth().digest("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority = 3)
	public void preemptiveAuthentication() {
		given() //user name postman and password password
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority = 4)
	public void bearerTokenAuth() {
		String token = "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";
		
		given()
			.header("Authorization","Bearer "+ token)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200);
//			.log().all();
	}
	
	//@Test
	public void oauth1Authentication() {
		given()
			.auth().oauth("consuerKey", "consumerSecret", "accessToken", "tokenSecret")
		.when()	
			.get()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 5)
	public void oauth2Authentication() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200);
//			.log().all();
	}
	
	@Test(priority = 6)
	public void apiKeyAuthentication() {
		given()
			.queryParam("appid", "f63cb451e699e81b8c81a6abcd88cd2c")
		.when()
			.get("https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=28.6667&lon=77.2167")
		.then()
			.statusCode(200)
			.log().all();
	}
}
