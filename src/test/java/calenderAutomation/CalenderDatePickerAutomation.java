package calenderAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDatePickerAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//img[@alt='Calendar-icon']")).click();

		// to go to future date 1st dec 2024
		// Click on the forward navigation arrow 12 times
		for (int i = 0; i <= 11; i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		}
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[1]/a")).click();

		// to go to past Date 1 Jan 2023
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Calendar-icon']")).click();

		for (int i = 0; i < 23; i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Prev')]")).click();
		}

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[1]/a")).click();
	}

}
