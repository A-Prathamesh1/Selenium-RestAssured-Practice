package restassuredday5;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
public class ParsingXMLresponse {

	//@Test
	public void testXMLResponse() {
		
		/*given()
			.queryParam("page", 1)
			.pathParam("traveller", "Traveler")
			
		.when()
			.get("http://restapi.adequateshop.com/api/{traveller}")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			//.body("TravelerinformationResponse.page", equalTo(1))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
			*/
		
		Response res = given()
			.queryParam("page", 1)
			.pathParam("traveller", "Traveler")
		.when()
			.get("http://restapi.adequateshop.com/api/{traveller}");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.contentType(),"application/xml; charset=utf-8");
		
		String pageno = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageno, "1");
		
		String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "Developer");
	}

@Test
public void testXMLResponseBody() {
	
	/*given()
		.queryParam("page", 1)
		.pathParam("traveller", "Traveler")
		
	.when()
		.get("http://restapi.adequateshop.com/api/{traveller}")
	.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		//.body("TravelerinformationResponse.page", equalTo(1))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
		*/
	
	Response res = given()
		.queryParam("page", 1)
		.pathParam("traveller", "Traveler")
	.when()
		.get("http://restapi.adequateshop.com/api/{traveller}");
	
	XmlPath xmlObj = new XmlPath(res.asString());
	//verify if there are 0 travelers
	List<String> travellers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	
	Assert.assertEquals(travellers.size(),10);
	
	//verify of traveler named Developer is present in response
	
	List<String> names = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	boolean status = false;
	for(String name: names) {
//		System.out.println(name);
		if(name.equals("Developer")) {
			status = true;
			break;
		}
	}
	Assert.assertEquals(status,true);
	
}

}