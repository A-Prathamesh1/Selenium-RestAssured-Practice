
package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {//
		WebDriver driver = new ChromeDriver();
		Wait<WebDriver> mywait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(3));

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("http://www.google.com");

		driver.manage().window().maximize();

		driver.navigate().refresh();

		// Thread.sleep(3000);
		// to solve ElementNotFound & NoSuchElementException
		// we use wait methods implicitlyWait() fluentWait()
		// Disadvantage of using thread.sleep
		// what if element we are waiting for takes more than
		// specified time. Also thread.sleep waits for specified time
		// Compulsory
		// another dis is we have to use it multiple time.
		// makes automation script slow

		// implicitlyWait()
		// adv: write once applicable everywhere
		// it will wait till element appears and till the given time.
		// dis: it time is not sufficient we can still get the exceptions

		// explicit wait/fluent wait
		// it is specific wait for particular element
		// first it will consider the condition then it will consider wait time
		// dis: first we need to declare and then use

		// Fluent wait
//		adv: doesn't wait for all the waiting time mentioned 
//		if element gets available within first few secs then it doesn't keep waiting

//		WebElement textarea = mywait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name=\"q\"]")));
		// driver.findElement(By.xpath("//textarea[@name=\"q\"]"));

		WebElement textArea = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//textarea[@name='q']"));
			}
		});
		// practice

		textArea.sendKeys("abc");
		textArea.sendKeys(Keys.F5); // to refresh the page
		driver.manage().deleteAllCookies();

		Actions action = new Actions(driver);
		action.doubleClick(textArea).build().perform();
	}

}
