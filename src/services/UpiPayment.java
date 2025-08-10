package services;

public class UpiPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount + "...");
        System.out.println("✅ Payment successful via UPI!");
    }
}
