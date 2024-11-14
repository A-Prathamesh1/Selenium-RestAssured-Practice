package designPatternSingletonSerialization;

import java.io.Serializable;

public class Browser implements Serializable {
	// 1. private static instance of class
	private static Browser browser;

//	 2. private constructor to prevent object creation 
	private Browser() {
	}

	// 3. public static getInstance method to get access of browser object
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

	// public instance method
	public void display() {
		System.out.println("display method of browser object");
	}

	// preventing object creation during de-srialization
	protected Object readResolve() {
		return getInstance();
	}
}
