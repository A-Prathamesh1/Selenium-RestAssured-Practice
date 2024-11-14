package restassuredday6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.javafaker.Faker;

public class SerializationDeserializationJSONXMLObject {

	// POJO ---> serialize -- > JSON Obj --> De-serialize --> POJO
	Student studPOJO = new Student();

	@Test
	public void serialization() throws JsonProcessingException {

		studPOJO.setName("Avyaan");
		studPOJO.setLocation("Pune");
		studPOJO.setPhoneno("12345679");
		String[] courses = { "AI", "ML" };
		studPOJO.setCourses(courses);

		// Convert java obj to JSON obj i.e. serialization

		ObjectMapper objMapper = new ObjectMapper();

		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studPOJO);

		System.out.println(jsonData);// jsonData contains serialized data
	}

	// @Test
	public void deserialize() throws JsonMappingException, JsonProcessingException {
		String jsonData = "{\r\n" + "  \"name\" : \"Avyaan\",\r\n" + "  \"location\" : \"Pune\",\r\n"
				+ "  \"phoneno\" : \"12345679\",\r\n" + "  \"courses\" : [ \"AI\", \"ML\" ]\r\n" + "}";

		// JSON Data --> POJO i.e. De-sirializing

		ObjectMapper objMapper = new ObjectMapper();

		Student studPOJO = objMapper.readValue(jsonData, Student.class); // studPOJO contains De-serialized data

		System.out.println("Name " + studPOJO.getName());
		System.out.println("Location " + studPOJO.getLocation());
		System.out.println("Phone no " + studPOJO.getPhoneno());
		System.out.println("Course 1 " + studPOJO.getCourses()[0]);
		System.out.println("Course 2 " + studPOJO.getCourses()[1]);

	}

// Following two does not work ******************************************************************************
	@Test
	public void serialieXMLData() throws JsonProcessingException {
		User user = new User();
		user.setName("Avyaan");
		user.setId("100");
		user.setEmail("Avyaan@gmail.com");

		XmlMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writeValueAsString(user);
		System.out.println(xml);

	}
// DOSENT work
	@Test
	public void deSerializeXMLData() throws JsonMappingException, JsonProcessingException {
		String xml = "<user><id>123</id><name>John Doe</name><email>john.doe@example.com</email></user>";

		XmlMapper xmlMapper = new XmlMapper();
		User user = xmlMapper.readValue(xml, User.class);

		System.out.println("User ID: " + user.getId());
		System.out.println("User Name: " + user.getName());
		System.out.println("User Email: " + user.getEmail());

	}
}
