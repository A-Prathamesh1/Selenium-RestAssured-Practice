package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersInXMLFileTest {
	@Parameters({ "username", "pass" })
	@Test
	public void parametersTest(String userName, String pass) {
		System.out.println(userName);
		System.out.println(pass);
	}
}
