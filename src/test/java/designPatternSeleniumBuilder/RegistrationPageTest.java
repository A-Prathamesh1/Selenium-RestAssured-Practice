package designPatternSeleniumBuilder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* YT Video: https://www.youtube.com/watch?v=XPXFjpe1q0U&list=PLFGoYjJG_fqpc4jcqbeXqMIT3-60nfLr6&index=9
 * When there is long registration form with many inputs needs to be filled up use builder pattern. 
 */

public class RegistrationPageTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
	}

	@Test
	public void regsiterationTest() throws InterruptedException {
		// we can chain different setters here and call build at the end to obtain the Register's object which we are building
		Register register = new Register.RegisterBuilder().setFirstName("Prathamesh").build();

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.userRegister(register);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
