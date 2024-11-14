package JavaOopsInheritance;

//  Multiple Inheritance

public class Square extends Shape implements Printable {

	@Override
	public void printable() {
		System.out.println("Printing the square");
	}

	@Override
	public void p() {
		System.out.println("print p overriden");
	}

	public static void main(String[] args) {
		Square s = new Square();// square has inherited from Shape as well as Printable
		s.draw();
		s.printable();
		s.printable();
		s.p();

	}
}
