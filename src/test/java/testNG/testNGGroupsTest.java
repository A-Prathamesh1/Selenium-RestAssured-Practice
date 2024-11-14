package testNG;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNGGroupsTest {

	@Test(threadPoolSize = 3, groups = "smoke", invocationCount = 3, invocationTimeOut = 1, priority = 0)
	public void test1() {
		// Test logic
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
//		Assert.fail();
	}

	@Test(priority = -1, groups = { "regression", "sanity" })
	public void test2() {
		// Test logic
		// Assert.fail();
	}

	@DataProvider(name = "testdata")
	public Object[] testDataProvider() {
		return new Object[] { 1, 2 };
	}
	
	@Test(dataProvider = "testdata", priority = 1, groups = "regression")
	public void test3(int val) {
		// Test logic
		System.out.println(val);

	}

}
