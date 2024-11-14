package JavaOopsInheritance;
/*
Hybrid Level Inheritance

Shape class
 |
\|/
Rectangle implements Printable, Measurable

*/

public class Rectangle extends Shape implements Mesaurable, Printable {

	@Override
	public void printable() {
		System.out.println("Printing rectangle");
	}

	@Override
	public void measure() {
		System.out.println("Printing mesurements");
	}

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		r.draw();// inherited from shape
		r.printable(); // overridden from printable
		r.measure(); // overridden from measurable
		
//		hybrid inheritance 
	}
}
