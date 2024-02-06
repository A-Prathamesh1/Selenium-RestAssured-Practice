package fromAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Register.html");

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Prat");

		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Aus");

		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("something");

		driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("abc@tes.com");

		driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("1234567890");

		driver.findElement(By.xpath("//input[@value='Male']")).click();

		driver.findElement(By.xpath("//input[@id='checkbox2']")).click();

//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@id='msdd']")).click();
//				+ "//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select")).click();

//		driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();

//		driver.findElement(By.xpath("//a[contains(text(),'Hindi')]")).click();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("var x,y; document.elementFromPoint(x, y).click();", 1, 1);

//		Thread.sleep(2000);

		System.out.print("this will print");

		WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));
//
		Select SkillSelect = new Select(skills);

		SkillSelect.selectByVisibleText("Software");
//
//		langSelect.selectByVisibleText("Hindi");
		driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("aHooooooooo@123");
	}

}
