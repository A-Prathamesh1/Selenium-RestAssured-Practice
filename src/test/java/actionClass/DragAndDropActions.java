package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/drag_drop.html");

		// drag and drop needs to click & hold the target element and move to element
		// and release

		WebElement soruceEle = driver.findElement(By.xpath("//*[@id='credit2']/a"));

		WebElement targetEle = driver.findElement(By.xpath("//*[@id='bank']/li"));

		Actions act = new Actions(driver);
		//1st way to do Drag and Drop
		// act.clickAndHold(soruceEle).moveToElement(targetEle).release().build().perform();
		
		//2nd way to do drag and drop
		act.dragAndDrop(soruceEle, targetEle).build().perform();

	}

}
