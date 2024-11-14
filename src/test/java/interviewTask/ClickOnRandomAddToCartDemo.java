package interviewTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnRandomAddToCartDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().window().maximize();

		//// div[@class="inventory_list"]/div

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		List<WebElement> li = driver
				.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
		int randomWebEle = (int) (Math.random() * li.size());
		Thread.sleep(3000);
		li.get(randomWebEle).click();

//		driver.quit();
	}

}
