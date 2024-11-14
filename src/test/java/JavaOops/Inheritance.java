package JavaOops;

/*
1. Single Level Inheritance
2. MultiLevel Inheritance
3. Hybrid Level Inheritance
		|
		|
	Shape class
		|
	   \|/
	Rectangle implements Printable, Measurable	
		
4. Hierarchical Inheritance
	  Vehical
		/ \
	   /   \
	 Car  Bike	
5. Multiple Inheritance */


// Single level inheritance
class Parent {
	String lastName;
}

public class Inheritance extends Parent {

	public static void main(String[] args) {
		Inheritance i = new Inheritance();
		i.lastName = "lastName";
		System.out.println(i.lastName);
	}
}

// see JavaOopsInheritance
