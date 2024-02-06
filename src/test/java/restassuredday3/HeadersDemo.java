package restassuredday3;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	
	//@Test(priority = 1)
		public void testHeaders() {
			given()
			.when()
				.get("http://www.google.com")
			.then()//it will fail as the AEC value will change
				.header("Content-Type","text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding", "gzip")
				.and()
				.header("Server", "gws");
				
		}
	
		@Test(priority = 1)
		public void getHeaders() {
			Response res = given()
			.when()
				.get("http://www.google.com");
			
			
			//get single header info
			String content_type_value = res.getHeader("Content-Type");
			System.out.println("value of content type :" + content_type_value);
			
			//get multiple headers
			Headers myheaders = res.getHeaders();
			
			for(Header h: myheaders) {
				System.out.println(h.getName() + " " + h.getValue());
			}
		}
	
		
	
}
