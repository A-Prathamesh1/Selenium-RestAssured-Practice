package headless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\geckodriver-v0.33.0-win64\\geckodriver.exe");

		// FirefoxOptions options = new FirefoxOptions();

//		options.setHeadless(true);
		// options.addArguments("--headless");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.google.com");

		System.out.println("title " + driver.getTitle());

		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'मराठी')]"));
//				linkText(
//				"https://www.google.com/setprefs?sig=0_SI_qM5m_Nitn8Wx1V2qYGAmPipc%3D&hl=mr&source=homepage&sa=X&ved=0ahUKEwid3ICe4pWDAxVUZ2wGHSN5C-gQ2ZgBCBU"));
// मराठी 
		String text = ele.getText();
		System.out.println(text);
//		driver.quit();
	}

}
