package restAssuredPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsDemo {

	@Test
	public void testSoftAssertions() {
		// Initialize SoftAssert object
		SoftAssert softAssert = new SoftAssert();

		// Example GET request
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
		
		// Do following to get cookies 
		Map<String, String> cookies = response.getCookies();
		System.out.println(cookies);

		// Perform soft assertions
		softAssert.assertEquals(response.getStatusCode(), 200, "Status code check failed");
		softAssert.assertTrue(response.getBody().asString().contains("userId"), "Body does not contain userId");
		softAssert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8",
				"Content-Type check failed");

		// This soft assertion will fail, but it won't stop the test
		softAssert.assertEquals(response.getStatusCode(), 404, "Status code is not 404");

		// This assertion will still be checked even though the previous one failed
		softAssert.assertTrue(response.getTime() < 2000, "Response time check failed");

		// Assert all - this will aggregate and report all soft assertion failures
		softAssert.assertAll();

	}
}
