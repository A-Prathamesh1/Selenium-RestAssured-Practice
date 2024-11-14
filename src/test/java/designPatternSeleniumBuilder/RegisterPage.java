package designPatternSeleniumBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	private WebDriver driver;
	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input�lastname");
	private final By email = By.id("input�emait");

	private final By telephone = By.id("input�telephone");
	private final By password = By.id("input�password");
	private final By confirmPassword = By.id(" input�confirm");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void userRegister(Register register) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(firstName).sendKeys(register.getFirstName());
		
	}
}
