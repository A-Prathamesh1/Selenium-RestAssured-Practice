package readingHTMLTableSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableReading {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium Project\\selenium-practice\\HTMLTable.html");

		// /html/body/table/tbody/tr[3]/td[2]

		// counting number of rows in table
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		int rowCount = rows.size();
//		System.out.println(rowCount);

		// counting the number of columns
		List<WebElement> columns = driver.findElements(By.xpath("/html/body/table/tbody/tr/th"));
		int columnCount = columns.size();
//		System.out.println(columnCount);

		for (int i = 2; i <= rowCount; i++) {
			for (int j = 1; j <= columnCount; j++) {
				System.out.print("  "
						+ driver.findElement(By.xpath("/html/body/table/tbody/tr[" + i + "]/td[" + j + "]")).getText());
			}
			System.out.println();
		}
	}

}
