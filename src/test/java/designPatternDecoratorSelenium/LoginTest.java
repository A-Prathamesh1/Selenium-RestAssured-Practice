package designPatternDecoratorSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void testLogin() {
		LoginPage loginPage = new LoginPage(driver);
		String title = loginPage.login("psausekar@gmail.com", "@WCcqBKt9N5AjuW");
		Assert.assertEquals(title, "My Account");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
