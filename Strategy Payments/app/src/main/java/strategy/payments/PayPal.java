package strategy.payments;

public class PayPal implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
    
}
