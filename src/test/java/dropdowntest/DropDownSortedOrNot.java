package dropdowntest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSortedOrNot {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium_4.16.1\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='third_date_picker']")).click();

		WebElement element = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

		Select selMonths = new Select(element);

		List originalList = new ArrayList();
		List tempList = new ArrayList();
		List<WebElement> options = selMonths.getOptions();

		for (WebElement e : options) {
			originalList.add(e.getText());
			tempList.add(e.getText());
		}

		System.out.println("Original List " + originalList);

		//tempList = originalList;

		Collections.sort(tempList);
		
		System.out.println("temp List " + tempList);
		
		System.out.println("Original List " + originalList);
		
		if (originalList == tempList) {
			System.out.println("DropDown list is sorted");
		} else {
			System.out.println("DropDown list is not sorted");
		}
	}

}
