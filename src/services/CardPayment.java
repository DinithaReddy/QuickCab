package services;

public class CardPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Card payment of ₹" + amount + "...");
        System.out.println("✅ Payment successful via Card!");
    }
}
