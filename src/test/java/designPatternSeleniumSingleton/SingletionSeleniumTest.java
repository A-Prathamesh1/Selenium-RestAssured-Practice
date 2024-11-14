package designPatternSeleniumSingleton;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SingletionSeleniumTest {
	private WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		driver = WebDriverManager.getInstance(browser).getDriver();
	}

	@Test
	public void googleTest() {
		driver.get("http://www.google.com");
		System.out.println(Thread.currentThread().getName() + ": " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@AfterClass
	public void tearDown() {
		WebDriverManager.quitBrowser();// this is doing driver.quit() for that thread
	}
}
