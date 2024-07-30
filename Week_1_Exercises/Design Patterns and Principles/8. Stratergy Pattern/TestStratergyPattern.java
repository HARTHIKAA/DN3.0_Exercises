public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay with Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/24");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.pay(250.0);

        // Pay with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.pay(150.0);
    }
}
