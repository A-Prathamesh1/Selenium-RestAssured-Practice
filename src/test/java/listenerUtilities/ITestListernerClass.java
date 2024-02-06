package listenerUtilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListernerClass implements ITestListener {
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed");
	}
}
