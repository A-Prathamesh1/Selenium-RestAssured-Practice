package restassuredday2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class WaysToCreatePostRequestBody {
	
	/*
	 * Different ways to create POST request body
	 * 1) POST req body using HashMap
	 * 2) POST req body using org.json library
	 * 3) POST req body using POJO class
	 * 4) POST req body using external JSON File
	 * */
	
	
	//1) POST req body using HashMap
	
	//@Test(priority = 1)
	public void postUsingHashMap() {
		HashMap<String, Object> data = new HashMap<>();
		data.put("name","Avyaan");
		data.put("location","Pune");
		data.put("phone","123456789");
		
		String[] coursesArr = {"ML","AI"};
		
		data.put("courses", coursesArr);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Avyaan"))
			.body("location",equalTo("Pune"))
			.body("phone",equalTo("123456789"))
			.body("courses[0]",equalTo("ML"))
			.body("courses[1]",equalTo("AI"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
//	2) POST req body using org.json library
	
	//@Test(priority = 1)
	public void postUsingOrgJsonLib() {
		JSONObject data = new JSONObject();
		
		String[] coursesArr = {"ML","AI"};
		data.put("name","Avyaan");
		data.put("location","Pune");
		data.put("phone","12456789");
		data.put("courses", coursesArr);
		
		given()
			.contentType("application/json")
			.body(data)//data.toString()
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Avyaan"))
			.body("location",equalTo("Pune"))
			.body("phone",equalTo("12456789"))
			.body("courses[0]",equalTo("ML"))
			.body("courses[1]",equalTo("AI"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	//3) POST req body using POJO class
	
	//@Test(priority = 1)
	public void postUsingPOJOClass() {
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("Avyaan");
		data.setLocation("Pune"); 
		data.setPhoneno("123456789");
		String[] courses = {"ML","AI"}; 
		data.setCourses(courses);
		
		given()
			.contentType("application/json")
			.body(data)//data.toString()
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Avyaan"))
			.body("location",equalTo("Pune"))
			.body("phoneno",equalTo("123456789"))
			.body("courses[0]",equalTo("ML"))
			.body("courses[1]",equalTo("AI"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	//4) POST req body using external JSON File
		
	@Test(priority = 1)
	public void postUsingExternalFile() throws FileNotFoundException {
		File file = new File(".\\body.json");
		
		FileReader fr = new FileReader(file);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);// import from org.json object
		
		
		given()
			.contentType("application/json; charset=utf-8")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.contentType("application/json; charset=utf-8")
			.body("name",equalTo("Avyaan"));
		
	}
		
	
	@Test(priority = 2)
	public void deleteData() {
		given()
		.when()
			.delete("http://localhost:3000/students/4")
		.then()
			.statusCode(200)
			.log().all();
	}
	
}
