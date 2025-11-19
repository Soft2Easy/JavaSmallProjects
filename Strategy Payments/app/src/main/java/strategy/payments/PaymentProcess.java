package strategy.payments;

public class PaymentProcess {
    private final Payment paymentStrategy;

    public PaymentProcess(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}
