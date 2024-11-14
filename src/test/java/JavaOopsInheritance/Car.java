package JavaOopsInheritance;

/*	Hierarchical Inheritance
  Vehical
	/ \
   /   \
 Car  Bike
 	
*/

public class Car extends Vehical {
	public void has4Wheels() {
		System.out.println("has 4 wheels");
	}

	public static void main(String[] args) {
		Car c = new Car();
		c.drive();
		c.has4Wheels();
	}

}
