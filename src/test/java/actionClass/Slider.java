package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/slider/");

		driver.switchTo().frame(0);

		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));

		Actions act = new Actions(driver);

		act.moveToElement(slider).dragAndDropBy(slider, 330, 0).build().perform();

		
	}
}
