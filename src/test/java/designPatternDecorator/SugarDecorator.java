package designPatternDecorator;

public class SugarDecorator extends CoffeeDecorator {

	public SugarDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + " , Sugar";
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 2.5; // added extra sugar
	}

}
