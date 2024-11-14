package designPatternSingleton;

public class TestBrowser {

	public static void main(String[] args) {
		Browser browser = Browser.getInstance();
		browser.display();
	}
	
}
