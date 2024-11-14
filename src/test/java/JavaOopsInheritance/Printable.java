package JavaOopsInheritance;

public interface Printable {
	public void printable();
	
	public default void p() {
		System.out.println("print p from Printable");
	}
}
