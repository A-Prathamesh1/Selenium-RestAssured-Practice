package readingHTMLTableSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HTMLTableAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\prath\\\\Documents\\\\Job\\\\SDET\\\\Selenium\\\\Selenium_4.16.1\\\\Drivers\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/tables");
		Thread.sleep(3000);

		// find the number of rows
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		// iterate through each row hard coding the column number
		for (int i = 1; i <= rowCount; i++) {
			String LastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[1]")).getText();
			String FirstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String email = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();
			String Due = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();
			String WebSite = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[5]")).getText();
			System.out.println(LastName + " " + FirstName + " " + email + " " + " " + Due + " " + WebSite);
		}
// ******************************* OR **********************************
		int colCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 1; j < colCount; j++) {
				String Value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.print(Value);
			}
			System.out.println();
		}
	}
}
