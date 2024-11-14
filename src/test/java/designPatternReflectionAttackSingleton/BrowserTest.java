package designPatternReflectionAttackSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BrowserTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// this here we will create two instances of the
		// browser one with getInstance() and another with
		// reflection API of java.
		// To test if our singleton creates single instance of
		// class, we will compare the hash code of the singleton objects
		// if the hash of both objects is same, then singleton is successful
		// otherwise it fails

		Browser browser = Browser.getInstance();
		Browser browser2 = null; // since get instance will return only one object

		Constructor<Browser> constructor = Browser.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		browser2 = constructor.newInstance();

		System.out.println(browser.hashCode());
		System.out.println(browser2.hashCode());
		// hash code of both instance is diff, and hence singleton is hacked/failed
		
		

	}

}
