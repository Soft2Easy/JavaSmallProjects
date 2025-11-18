package payment.options;

public class PaymentFactory {
    public static Payment getPaymentMethod(String method) {
        if (method.equalsIgnoreCase("paypal")) {
            return new Paypal();
        } else if (method.equalsIgnoreCase("card")) {
            return new CardPayment();
        }
        throw new IllegalArgumentException("Unknown payment method: " + method);
    }
}
