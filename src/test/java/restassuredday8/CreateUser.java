package restassuredday8;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
	public void createUser_Test(ITestContext context) {
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		
		data.put("gender", "male");
		
		data.put("email", faker.internet().emailAddress());
		
		data.put("status", "inactive");
		
		String bearerToken = "33c0467f6bbd626f380179d9f4e6c067b2a29454b479dd4f088adf9cde18356a";
		
		int id = given()//content type is being sent as header then we can use ContentType.JSON
			.header("Authorization","Bearer "+ bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		//int id = (int) context.getAttribute("user_id");
		context.getSuite().setAttribute("user_id", id);

	}
}
