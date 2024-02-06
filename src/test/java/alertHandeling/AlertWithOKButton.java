package alertHandeling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertWithOKButton {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		// alert with OK button example 
		driver.findElement(By.xpath("//a[@href='#OKTab']")).click();

		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();

		// get the text what pop up says
		System.out.println(driver.switchTo().alert().getText());

		// accept the pop up message
		driver.switchTo().alert().accept();
	}

}
