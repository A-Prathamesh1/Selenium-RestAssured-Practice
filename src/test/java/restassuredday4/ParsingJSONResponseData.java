package restassuredday4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {
	
	//@Test
	public void jsonResponseTest() {
		
		//approach no 1
		/*given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.body("book[1].title", equalTo("Sword of Honour"))
			.log();
		*/
		
		Response res  = given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(),200);//validation 1
		Assert.assertEquals(res.contentType(),"application/json; charset=utf-8");
		Assert.assertEquals(res.jsonPath().get("book[1].title").toString(), "Sword of Honour");
		
		
	}
	
	@Test
	public void jsonResponseBodyData() {
		
		//approach no 1
		/*given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.body("book[1].title", equalTo("Sword of Honour"))
			.log();
		*/
		
		Response res  = given()
			.contentType(ContentType.JSON)//"application/json; charset=utf-8")
		.when()
			.get("http://localhost:3000/store");
		
		/*Assert.assertEquals(res.statusCode(),200);//validation 1
		Assert.assertEquals(res.contentType(),"application/json; charset=utf-8");
		Assert.assertEquals(res.jsonPath().get("book[1].title").toString(), "Sword of Honour");*/
		
		//JSONObject class
		
		JSONObject jo = new JSONObject(res.asString());
		/*
		for(int i = 0; i < jo.getJSONArray("book").length(); i++) {
			System.out.println(jo.getJSONArray("book").getJSONObject(i).get("title").toString());
		}
		*/
		//assert if the book of desired title is present 
		boolean status = false;
		for(int i = 0; i <jo.getJSONArray("book").length(); i++) {
			
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			if(bookTitle.equals("Sword of Honour")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		
		//assert for the sum of book prices
		double totalPrice = 0;
		for(int i = 0; i <jo.getJSONArray("book").length(); i++) {
			
			String priceOfBook = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
			totalPrice += Double.parseDouble(priceOfBook);
			
		}
		Assert.assertEquals(totalPrice, 250.50);
	}
	
	
}
