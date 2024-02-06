package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	//Created to perform CRUD operations for USER section
	
	public static Response createUser(User payload) {
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return res;
		
	}
	
	public static Response getUserByName(String username) {
		Response res = given()
							.accept("application/json")
							.pathParam("username", username)
						.when()
							.get(Routes.get_url);
		return res;
	}
	
	public static Response updateUser(String username, User payload) {
		Response res = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("username", username)
							.body(payload)
						.when()
							.put(Routes.update_url);
		return res;
	}
	
	public static Response deleteUser(String username) {
		Response res  = given()
							.accept(ContentType.JSON)
							.pathParam("username", username)
						.when()
							.delete(Routes.delete_url);
		return res;
	}
}
