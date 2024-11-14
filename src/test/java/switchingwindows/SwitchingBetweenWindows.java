package switchingwindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingBetweenWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Windows.html");

		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();

		String title = driver.getTitle();

		System.out.println(title);

		Set<String> handles = driver.getWindowHandles();

		System.out.println(handles);

		for (String s : handles) {

			String title1 = driver.switchTo().window(s).getTitle();

			if (title1.contains("Selenium")) {
				driver.close();
			}
			
		}
//		driver.quit();
	}

}
