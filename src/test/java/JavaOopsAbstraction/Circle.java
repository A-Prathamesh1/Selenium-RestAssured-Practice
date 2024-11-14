package JavaOopsAbstraction;

public class Circle extends AbstractClassShape implements CalcArea {
	public int radius;

	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double calcArea() {
		return radius * radius * Math.PI;
	}

	public static void main(String[] args) {
		Circle c = new Circle();
		c.radius = 10;
		System.out.println(c.calculateArea());
		System.out.println(c.calcArea());
	}

}
