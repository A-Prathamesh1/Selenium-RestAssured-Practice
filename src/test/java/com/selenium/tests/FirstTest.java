package com.selenium.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		WebElement el = driver.findElement(By.id("APjFqb"));
		el.click();
		el.sendKeys("Prathamesh Ausekar");
		WebElement serachButton = driver.findElement(By.name("btnK"));
		serachButton.click();
		String curURL = driver.getCurrentUrl();
		System.out.println("current URL " + curURL);
		System.out.println("Title of page " + driver.getTitle());
		driver.manage().window().maximize();
//		Set myCookies = driver.manage().getCookies();
//		System.out.println(myCookies);
		driver.quit();

		// selenium version 4.16.1
		// java version 16.0.1
		// chrome driver version 2.42.591088
	}
}