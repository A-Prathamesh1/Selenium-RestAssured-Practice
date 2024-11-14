package designPatternDecorator;

public class MilkDecorator extends CoffeeDecorator {

	public MilkDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + " " + " , Milk";
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 1.5; // adding extra milk worth 1.5
	}
}
