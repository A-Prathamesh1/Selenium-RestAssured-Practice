package designPatternSingletonSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BrowserTestToPreventObjectCreationDuringSeriAndDesri {

	public static void main(String[] args) {
		try {
			Browser browser1 = Browser.getInstance();

			// Serialize browser instance
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("browser.json"));
			out.writeObject(browser1);
			out.close();

			// De-serialize the browser object stored in browser.txt
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("browser.json"));
			Browser browser2 = (Browser) in.readObject();
			in.close();

			System.out.println(browser1.hashCode());
			System.out.println(browser2.hashCode());
			// hash codes are different and hence singleton is violated

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
