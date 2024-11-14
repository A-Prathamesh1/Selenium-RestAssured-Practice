package designPatternSeleniumSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	// 1. private static object of browser class
	private static volatile WebDriverManager instance;
	// every thread will have their own copy of driver
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	// 2. private constructor of WebDriverManager
	private WebDriverManager() {
	}

	// 3. setting tlDriver value with webdriver instance
	private void initDriver(String browser) {
		switch (browser) {
		case "chrome":
			System.out.println("setting tlDriver");
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver());
			break;
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
		default:
			throw new IllegalArgumentException("Unsupported Driver " + browser);
		}
	}

	// 4. getInstance()
	// avoid writting synchronized to allow access multiple therad
	public static WebDriverManager getInstance(String browser) {
		if (instance == null) {
			synchronized (WebDriverManager.class) {
				if (instance == null) {
					instance = new WebDriverManager();
				}
			}
		}
		if (tlDriver.get() == null) {
			instance.initDriver(browser);
		}
		return instance;
	}

	// 5. to get driver in test methods
	public WebDriver getDriver() {
		return tlDriver.get();
	}

	// 6. public static quitting driver
	public static void quitBrowser() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit(); // driver.quit()
			tlDriver.remove();
		}
	}
}
