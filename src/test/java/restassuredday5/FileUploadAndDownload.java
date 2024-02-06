package restassuredday5;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
	@Test
	public void fileUpload() {
		
		File f = new File("C:\\Users\\prath\\Documents\\Job\\SDET\\Postman\\Pet Store.postman_test_run.json");
		
		given()
			.contentType("multipart/form-data")
			.multiPart(f)
		.when()
			.post("http://postman-echo.com/post")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void mulipleFileUpload() {
		File f1 = new File("C:\\\\Users\\\\prath\\\\Documents\\\\Job\\\\SDET\\\\Postman\\\\Pet Store.postman_test_run.json");
		File f2 = new File("C:\\\\Users\\\\prath\\\\Documents\\\\Job\\\\SDET\\\\Postman\\\\store.json");
		
		File files[] = {f1,f2}; 
		
		given()
			.contentType("multipart/form-data")
			.multiPart("files",f1)//files
			.multiPart("files",f2)
		.when()
			.post("http://postman-echo.com/post")
		.then()
			.statusCode(200);
	}
}
