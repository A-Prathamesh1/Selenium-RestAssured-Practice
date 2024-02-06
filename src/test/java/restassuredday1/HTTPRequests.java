package restassuredday1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

class HTTPRequests {

	int id;

	@Test(priority = 0)
	public void getUsers() {
		/**
		 * get user https://reqres.in/api/users?page=2 
		 * post user
		 * https://reqres.in/api/users { "name": "morpheus", "job": "leader" } 
		 * put users
		 * https://reqres.in/api/users/2 { "name": "morpheus", "job": "zion resident" }
		 * Delete users 
		 * https://reqres.in/api/users/2
		 * 
		 */
		given()
			.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2));
//			.log().all();
	}

	@Test(priority = 1)
	public void postUser() {
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Prathamesh");
		data.put("job", "SDET");

		id = given()
				.contentType("application/json")
				.body(data)
			.when()
				.post("https://reqres.in/api/users")
				.jsonPath()
				.getInt("id");
	}
	
	@Test(priority = 2, dependsOnMethods = {"postUser"})
	public void putUser() {
		//https://reqres.in/api/users/2 { "name": "morpheus", "job": "zion resident" }
		HashMap<String, String> updateData = new HashMap<>();
		updateData.put("name", "prat");
		updateData.put("job", "SDE");
		
		given()
			.contentType("application/json")
			.body(updateData)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.body("job",equalTo("SDE"))
			.log().all();
	}
	
	@Test(priority = 3, dependsOnMethods = {"postUser"})
	public void deleteUser() {
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
}