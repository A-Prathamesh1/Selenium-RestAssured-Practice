package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepCommand {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		// to solve ElementNotFound & NoSuchElementException
		// we use wait methods
		// Disadvantage of using thread.sleep
		// what if element we are waiting for takes more than 
		// specified time. Also thread.sleep waits for specified time 
		// Compulsory 
		// another dis is we have to use it multiple time.
		// makes automation script slow
		
		
		WebElement textarea = driver.findElement(By.xpath("//textarea[@name=\"q\"]"));
		
		textarea.sendKeys("abc");
		
	}

}
