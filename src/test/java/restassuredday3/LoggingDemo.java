package restassuredday3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class LoggingDemo {
	
	@Test
	public void testLogs() {
		given()
		
		.when()
			.get("https://www.reqres.in/api/users?page=2")
		.then()
			.log().all();
//			.headers();
//			.cookies();
//			.body();
	}
}
