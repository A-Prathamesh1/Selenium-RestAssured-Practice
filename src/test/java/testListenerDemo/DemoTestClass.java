package testListenerDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestClass {
	@Test
	public void test() {
		System.out.println("Inside test");
		Assert.fail();
	}
}
