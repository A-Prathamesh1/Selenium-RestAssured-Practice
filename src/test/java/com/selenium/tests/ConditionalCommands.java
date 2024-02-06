package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//
		driver.get("https://www.facebook.com/");
//
//		WebElement searchBox = driver.findElement(By.id("APjFqb"));
//
//		System.out.println(searchBox.isDisplayed());
//
//		System.out.println(searchBox.isEnabled());

//		driver.navigate().to("https://www.facebook.com/");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"))
				.click();

		System.out.println("is male radio button displayed ");

		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_2_o_gV\"]/span[2]/label")).isDisplayed());

		System.out.println("is male radio button enabled ");

		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_2_o_gV\"]/span[2]/label")).isEnabled());

		driver.quit();
	}

}
