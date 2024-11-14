package designPatternDecoratorSelenium;

import org.openqa.selenium.WebElement;

public class LoggingDecorator extends WebElementDecoratorBase {

	public LoggingDecorator(WebElementDecorator decoratedElement) {
		super(decoratedElement);
	}

	@Override
	public void click(WebElement element) {
		// technically log4j should be used to log the action, but for the sake of
		// demonstration we are using syso
		System.out.println("Clicking the webelement: " + element);
		super.click(element);
	}

	@Override
	public void sendKeys(WebElement element, String text) {
		System.out.println("Entering " + text + " into element " + element);
		super.sendKeys(element, text);
	}
}
