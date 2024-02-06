package restassuredday8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class GetUser {
	
	@Test
	public void getUser_Test(ITestContext context) {
//		int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");
		
		String bearerToken = "33c0467f6bbd626f380179d9f4e6c067b2a29454b479dd4f088adf9cde18356a";
		given()
			.header("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
