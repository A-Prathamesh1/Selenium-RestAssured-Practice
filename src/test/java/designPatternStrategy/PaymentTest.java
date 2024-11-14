package designPatternStrategy;

public class PaymentTest {

	public static void main(String[] args) {
		PaymentContext context = new PaymentContext(new BankTransferPayment());
		context.pay(1000);

		context.setPaymentStrategy(new CreditCardPayment());
		context.pay(2000);

		context.setPaymentStrategy(new PayPalPayment());
		context.pay(3000);
	}
}
