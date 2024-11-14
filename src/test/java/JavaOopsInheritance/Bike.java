package JavaOopsInheritance;

/*	Hierarchical Inheritance
  Vehical
	/ \
   /   \
 Car  Bike	
*/

public class Bike extends Vehical {

	public void has2Wheels() {
		System.out.println("has 2 wheels");
	}

	public static void main(String[] args) {

		Bike b = new Bike();
		b.drive();
		b.has2Wheels();
	}
}
