package designPatternDecorator;

public class CreameDecorator extends CoffeeDecorator {

	public CreameDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + " , Creme";
	}

	@Override
	public double getCost() {
		return coffee.getCost() + 5; // added extra creme
	}
}
