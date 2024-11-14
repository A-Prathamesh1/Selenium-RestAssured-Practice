package designPatternSeleniumBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	private WebDriver driver;
	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input様astname");
	private final By email = By.id("input容mait");

	private final By telephone = By.id("input葉elephone");
	private final By password = By.id("input用assword");
	private final By confirmPassword = By.id(" input幼onfirm");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void userRegister(Register register) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(firstName).sendKeys(register.getFirstName());
		
	}
}
