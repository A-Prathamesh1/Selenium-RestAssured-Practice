package restassuredday3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
	//@Test(priority = 1)
	public void testCookies() {
		given()
		.when()
			.get("http://www.google.com")
		.then()//it will fail as the AEC value will change
			.cookie("AEC","Ae3NU9P0eK-LJ-NgybJHijK6wUGHT5046kRdUK7gIpdlwGzFw_XnBKq6Zw")
			.log().all();
	}
	
	@Test(priority = 2)
	public void getCookiesInfo() {
		Response res = given()
		.when()
			.get("http://www.google.com");
		
		
		//get single cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("value of cookie " + cookie_value);
		
		//getting value of all the cookies
		Map<String, String> cookies = res.cookies();
		
		for(String key: cookies.keySet()) {
			System.out.println("Cookie " + key + " value: " + res.getCookie(key));
		}
	}
	
	
}
