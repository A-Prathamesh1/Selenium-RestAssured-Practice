package restAssuredPractice;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CRUDWithRestAssured {

	@Test
	public void createUserUsingPost() {
		baseURI = "https://reqres.in/api";

		HashMap<String, String> data = new HashMap<>();

		JSONObject userData = new JSONObject(data);

		userData.put("name", "Prathamesh");
		userData.put("role", "automation engineer");

//		Response res =
		String strRes = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(userData.toJSONString()).when().post("users").then().extract()
				.asString();
		System.out.println(strRes);
//		.then()
//			.statusCode(201)
//			.log().all();
//		String resdata = res.jsonPath();
		/*
		 * Map<String, String> cookies = res.cookies(); // System.out.println(resdata);
		 * long resTime = res.time(); System.out.println(resTime); int statusCode =
		 * res.getStatusCode(); System.out.println(); Assert.assertEquals(statusCode,
		 * 201); String role = res.jsonPath().get("role"); System.out.println(role);
		 * String resData = res.jsonPath().get("name"); System.out.println(resData);
		 * Assert.assertEquals(resData, "Prathamesh");
		 */
	}

	@Test
	public void getUsers() {
		baseURI = "https://reqres.in/api";
		// time(Matchers.lessThan(1000))
		given().when().get("/users?page=2").then().statusCode(200);
		// .("data[4].first_name", equalTo("George")).log() .all();

	}

	@Test
	public void headRequest() {
		baseURI = "https://reqres.in/api";

		given().when().head("/users?page=2").then().statusCode(200).header("Content-Type",
				"application/json; charset=utf-8");
//			.body("data[4].first_name", equalTo("George"));
	}

	@Test
	public void putUser() {
		baseURI = "https://reqres.in/api";

		JSONObject newData = new JSONObject();
		newData.put("name", "Pranil");
		newData.put("role", "SDET");

		given().header("Content-Type", "aplication/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(newData.toJSONString()).when().put("users/499").then().statusCode(200).log().all();
	}

	@Test
	public void patchUser() {
		// partially updating the contents of the resource

		baseURI = "https://reqres.in/api";

		JSONObject patchedData = new JSONObject();
		patchedData.put("name", "Dnyaneshwar");

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(patchedData.toJSONString()).when().patch("users/371").then().statusCode(200).log().all();

	}

	@Test
	public void deleteUser() {
		baseURI = "https://reqres.in/api";

		when().delete("users/499").then().statusCode(204).log().all();
	}
	/*
	 * @Test public void optionsTest() { baseURI = "https://reqres.in/api";
	 * 
	 * given() .when() .options("/users") .then() .statusCode(204) .header("Allow",
	 * containsString()); }
	 */
}
