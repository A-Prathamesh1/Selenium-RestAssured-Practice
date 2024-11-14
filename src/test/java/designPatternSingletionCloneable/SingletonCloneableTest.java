package designPatternSingletionCloneable;

public class SingletonCloneableTest {

	public static void main(String[] args) {
		Browser instance1 = Browser.getInstance();
		try {
			Browser instance2 = (Browser) instance1.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
