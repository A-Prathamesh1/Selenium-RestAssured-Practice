package designPatternStrategy;

public class CreditCardPayment implements PaymentStrategy {

	// Single responsibility principle: credit card payment is responsible for
	// making payments using credit cards and nothing else

	@Override
	public void pay(double amount) {
		System.out.println("Making payment of " + amount + " using Credit card.");
	}

}
