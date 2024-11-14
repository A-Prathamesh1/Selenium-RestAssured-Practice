package ExceptionsInJava;

public class MyClass {
	public void checkValue(int val) throws MyCustomException{
		if(val < 0) {
			throw new MyCustomException("value passed is less than 0");
		}
	}
}
