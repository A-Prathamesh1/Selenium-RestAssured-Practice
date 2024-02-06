package restassuredday6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {

	// POJO ---> serialize -- > JSON Obj --> De-serialize --> POJO
	Student studPOJO = new Student();

	//@Test
	public void serialization() throws JsonProcessingException {

		studPOJO.setName("Avyaan");
		studPOJO.setLocation("Pune");
		studPOJO.setPhoneno("12345679");
		String[] courses = { "AI", "ML" };
		studPOJO.setCourses(courses);

		// Convert java obj to JSON obj i.e. serialization

		ObjectMapper objMapper = new ObjectMapper();

		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studPOJO);

		System.out.println(jsonData);
	}

	@Test
	public void deserialize() throws JsonMappingException, JsonProcessingException {
		String jsonData = "{\r\n" + "  \"name\" : \"Avyaan\",\r\n" + "  \"location\" : \"Pune\",\r\n"
				+ "  \"phoneno\" : \"12345679\",\r\n" + "  \"courses\" : [ \"AI\", \"ML\" ]\r\n" + "}";

		// JSON Data --> POJO i.e. De-sirializing

		ObjectMapper objMapper = new ObjectMapper();

		Student studPOJO = objMapper.readValue(jsonData, Student.class);

		System.out.println("Name " + studPOJO.getName());
		System.out.println("Location " + studPOJO.getLocation());
		System.out.println("Phone no " + studPOJO.getPhoneno());
		System.out.println("Course 1 " + studPOJO.getCourses()[0]);
		System.out.println("Course 2 " + studPOJO.getCourses()[1]);

	}
}
