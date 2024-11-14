package designPatternReflectionAttackSingleton;

public class Browser {
	// 1. Private static instance of class
	private static Browser browser;

	// 2. private constructor
	private Browser() {
		// prevention form reflection attack
		if (browser != null) {
			throw new IllegalArgumentException("Browser object already exists with hashcode: " + browser.hashCode());
		}
	}

	// 3. getInstance() to get access to instance of class
	public static Browser getInstance() {
		if (browser == null) {
			synchronized (Browser.class) {
				if (browser == null) {
					browser = new Browser();
				}
			}
		}
		return browser;
	}

	// public method of class
	public void display() {
		System.out.println("Display method of broweser class");
	}
}
