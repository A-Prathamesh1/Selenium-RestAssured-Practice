package designPatternFactory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// What is factory design pattern
		// Complete isolation of object creation

		CarFactory factory = new CarFactory();

		Car suvCar = factory.getCar("SUV");
		suvCar.assemble();

		Car sedanCar = factory.getCar("SEDAN");
		sedanCar.assemble();

		Car miniCar = factory.getCar("MINI");
		miniCar.assemble();
	}

}
