package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("http://www.google.com");

		driver.manage().window().maximize();

		// Thread.sleep(3000);
		// to solve ElementNotFound & NoSuchElementException
		// we use wait methods implicitlyWait() fluentWait()
		// Disadvantage of using thread.sleep
		// what if element we are waiting for takes more than
		// specified time. Also thread.sleep waits for specified time
		// Compulsory
		// another dis is we have to use it multiple time.
		// makes automation script slow

		//implicitlyWait()
		// adv: write once applicable everywhere
		// it will wait only till element appears, it wont take all the time mentioned 
		// dis: it time is not sufficient we can still get the exceptions
		
		// explicit wait/fluent wait 
		// 
		WebElement textarea = driver.findElement(By.xpath("//textarea[@name=\"q\"]"));

		textarea.sendKeys("abc");
	}
}
