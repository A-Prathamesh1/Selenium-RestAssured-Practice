package designPatternStrategy;

public class PayPalPayment implements PaymentStrategy {

	// Single responsibility principle: Pay pal payment is responsible for
	// making payments using pay pal and nothing else

	
	@Override
	public void pay(double amount) {
		System.out.println("Making payment of " + amount + " using PayPal.");
	}

}
