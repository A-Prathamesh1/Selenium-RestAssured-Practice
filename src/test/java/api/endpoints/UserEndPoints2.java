package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	//created for getting urls from properties file
	public static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	//Created to perform CRUD operations for USER section
	
	public static Response createUser(User payload) {
		String post_url = getURL().getString("post_url");
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		
		return res;
		
	}
	
	public static Response getUserByName(String username) {
		String get_url = getURL().getString("get_url");
		Response res = given()
							.accept("application/json")
							.pathParam("username", username)
						.when()
							.get(get_url);
		return res;
	}
	
	public static Response updateUser(String username, User payload) {
		String update_url = getURL().getString("update_url");
		Response res = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("username", username)
							.body(payload)
						.when()
							.put(update_url);
		return res;
	}
	
	public static Response deleteUser(String username) {
		String delete_url = getURL().getString("delete_url");
		Response res  = given()
							.accept(ContentType.JSON)
							.pathParam("username", username)
						.when()
							.delete(delete_url);
		return res;
	}
}
