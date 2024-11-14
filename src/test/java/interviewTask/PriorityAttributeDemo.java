package interviewTask;

import org.testng.annotations.Test;

/*
 * 
 * 1. THE DEFAULT PRIORITY OF THE TEST CASE IN TestNG is 0,i.e. if you don't give any priority to the test case then its priority is 0
 * 2. no priority is set, TestNG executes the methods in alphabetical order
 * 3. If some methods have priorities and others don’t, TestNG first executes the methods with explicit priorities (starting with the lowest priority number),
 *  and then it executes the rest in alphabetical order (which effectively have a default priority of 0).
 * */

public class PriorityAttributeDemo {

	@Test
	public void btest1() {
		System.out.println("test b1");
	}

	@Test(priority = 1)
	public void atest2() {
		System.out.println("test a2");
	}

	@Test
	public void ctest3() {
		System.out.println("test c3");
	}

	@Test(enabled = false)
	public void test4() {
		System.out.println("test 4");
	}

	@Test(enabled = false)
	public void test5() {
		System.out.println("test 5");
	}

}
