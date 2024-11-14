package ExceptionsInJava;

public class Main {

	public static void main(String[] args) throws MyCustomException {
		MyClass m = new MyClass();

		try {
			m.checkValue(-1);
			System.out.println("try block..."); // wont execute: as soon the exception is caught the control passed to
												// catch block
		} catch (MyCustomException e) {
			System.out.println("catch block..." + e.getMessage());
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally...");
		}
	}
}
