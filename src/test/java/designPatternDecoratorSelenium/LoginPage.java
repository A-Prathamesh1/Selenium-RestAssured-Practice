package designPatternDecoratorSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	private WebElementDecorator webElementActions;

	/*
	 * By userName = By.id("input-email"); By password = By.id("input-password"); By
	 * loginButton = By.xpath("//input[@type='submit']");
	 */
	@FindBy(id = "input-email")
	WebElement userName;

	@FindBy(id = "input-password")
	WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// 1. Normal webelement actions
		webElementActions = new WebElementActions();
		// 2. webelementActions can be assigned with any decorator as its base type of
		// WebElement decorator
		// webElementActions = new WaitDecorator(new LoggingDecorator(new
		// WebElementActions()), driver);
		// 3.
		webElementActions = new LoggingDecorator(new WebElementActions());

	}

	public String login(String username, String password) {
		webElementActions.sendKeys(userName, username);
		webElementActions.sendKeys(passwordField, password);
		webElementActions.click(submitButton);
		return driver.getTitle();
	}
}
