package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/hovers");

		WebElement imageIconElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));

		Actions act = new Actions(driver);

		act.moveToElement(imageIconElement).build().perform();

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
		
		
	}

}
