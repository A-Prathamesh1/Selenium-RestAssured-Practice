package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\prath\\\\Documents\\\\Job\\\\SDET\\\\Selenium\\\\Selenium_4.16.1\\\\Drivers\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

//		options.setHeadless(true);
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);

		driver.get("http://www.google.com");

		System.out.println("title " + driver.getTitle());
		
		driver.quit();
	}

}
