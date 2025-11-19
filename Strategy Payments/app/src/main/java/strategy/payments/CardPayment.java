package strategy.payments;

public class CardPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card Payment.");
    }
    
}
