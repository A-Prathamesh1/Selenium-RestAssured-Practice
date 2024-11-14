package designPatternStrategy;

public class BankTransferPayment implements PaymentStrategy {

	// Single responsibility principle: Bank transfer payment is responsible for
	// making payments using bankTransfer Payment and nothing else

	@Override
	public void pay(double amount) {
		System.out.println("Making payment of " + amount + " using Bank Transfer.");
	}

}
