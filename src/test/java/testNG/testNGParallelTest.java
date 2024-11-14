package testNG;

import org.testng.annotations.Test;

public class testNGParallelTest {
	@Test // (groups = "smoke")
	public void test3() {
		// Test logic
//		Assert.fail();
	}

	@Test // (groups = { "regression", "sanity" })
	public void test4() {
		// Test logic
		// Assert.fail();
	}

	@Test // (groups = "regression")
	public void test5() {
		// Test logic
	}

}
