package designPatternDecoratorSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDecorator extends WebElementDecoratorBase {
	private WebDriver driver;

	public WaitDecorator(WebElementDecorator decoratedElement, WebDriver driver) {
		super(decoratedElement);
		this.driver = driver;
	}

	@Override
	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Waiting for element " + element + " to be visible before clicking");
		super.click(element);
	}

	@Override
	public void sendKeys(WebElement element, String text) {
		// explicitly waiting for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Waiting for element " + element + " to be visoble before sending keys");
		super.sendKeys(element, text);
	}
}
