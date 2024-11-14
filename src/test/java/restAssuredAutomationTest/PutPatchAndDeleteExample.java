package restAssuredAutomationTest;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteExample {

	@Test
	public void testPut() {
		JSONObject req = new JSONObject();

		req.put("name", "Prathamesh");
		req.put("role", "SDET");

		baseURI = "https://reqres.in/api";

		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.put("users/2")
			.then()
			.statusCode(200)
			.log().all();
	}

	@Test
	public void testPatch() {
		JSONObject req = new JSONObject();

		req.put("Name", "Prathamesh");
		req.put("role", "SDET");

		baseURI = "https://reqres.in/api";

		given()
			.header("ContentType", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.patch("users/2")
		.then()
			.statusCode(200).log().all();
	}

	@Test
	public void testDelete() {

		baseURI = "https://reqres.in/api";
		when().delete("users/2").then().statusCode(204).log().all();
	}
}
