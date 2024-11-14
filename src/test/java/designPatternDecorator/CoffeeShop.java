package designPatternDecorator;

public class CoffeeShop {

	public static void main(String[] args) {

		// decorator works on open close principle

		Coffee myCoffee = new SimpleCoffee();
		System.out.println(myCoffee.getCost() + " " + myCoffee.getDescription());

		// up-casting ?????????
		myCoffee = new MilkDecorator(myCoffee);
		System.out.println(myCoffee.getCost() + " " + myCoffee.getDescription());

		myCoffee = new SugarDecorator(myCoffee);
		System.out.println(myCoffee.getCost() + " " + myCoffee.getDescription());

		myCoffee = new CreameDecorator(myCoffee);
		System.out.println(myCoffee.getCost() + " " + myCoffee.getDescription());
	}
}
