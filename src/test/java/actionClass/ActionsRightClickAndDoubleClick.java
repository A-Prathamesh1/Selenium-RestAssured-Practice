package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRightClickAndDoubleClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement rightClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));

		Actions act = new Actions(driver);
		// Right click example
		act.contextClick(rightClick).build().perform();

		driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]")).click();

		driver.switchTo().alert().accept();
		// Double click example

		WebElement doubleClickEle = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));

		act.doubleClick(doubleClickEle).build().perform();

	}

}
