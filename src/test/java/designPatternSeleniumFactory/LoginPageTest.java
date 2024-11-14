package designPatternSeleniumFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

//https://www.youtube.com/watch?v=mVIWw59tj84&list=PLFGoYjJG_fqpc4jcqbeXqMIT3-60nfLr6&index=7

public class LoginPageTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver("edge").createDriver();
		// driver.get(null);
	}

	@Test
	public void loginTest() {
		Assert.assertEquals(true, true);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
