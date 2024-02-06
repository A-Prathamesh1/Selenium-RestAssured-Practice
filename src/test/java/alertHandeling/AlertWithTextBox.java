package alertHandeling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertWithTextBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");

		// alert with text box example

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();

		// switch to alert box and send keys
		driver.switchTo().alert().sendKeys("This is messge");

		driver.switchTo().alert().accept();
	}

}
