package designPatternSeleniumFactory;

public class DriverFactory {
	public static BrowserDriver getDriver(String browserType) throws Exception {
		switch (browserType) {
		case "chrome":
			return new ChromeDriverManager();
		case "firefox":
			return new FireFoxDriverManager();
		case "edge":
			return new EdgeDriverManager();
		default:
			throw new IllegalArgumentException("Invalid browser name " + browserType);
		}
	}
}
