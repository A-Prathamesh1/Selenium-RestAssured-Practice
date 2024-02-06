package calenderAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarAutoExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

		driver.findElement(By.xpath("//input[@id='third_date_picker']")).click();

		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

		Select yearSelect = new Select(year);

		// Select Future Date 1 Dec 2024

		yearSelect.selectByVisibleText("2024");

		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

		Select monthSelect = new Select(month);

		monthSelect.selectByVisibleText("Dec");

		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[1]/a")).click();

		// To Do: Select past date.
	}

}
