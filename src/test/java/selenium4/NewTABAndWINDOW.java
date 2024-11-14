package selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTABAndWINDOW {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.facebook.com");

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://www.bing.com");
		
		driver.close();
		driver.quit();
	}
}
