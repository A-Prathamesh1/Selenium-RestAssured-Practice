package designPatternSingleton;

public class Browser {
	// 1. Private static instance of the class
	private volatile static Browser browser = null;

	// 2. Private constructor to prevent/avoid instantiation
	private Browser() {
	};

	// 3. Public static getInstance method to get access to instance
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

	// OPtional public method of class
	public void display() {
		System.out.println("display method of browser class");
	}
	
}
