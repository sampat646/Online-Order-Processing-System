package org.interFace.project;

public class MockPaymentGateway implements IPaymentGateway{
    @Override
    public boolean processPayment(int orderId, double amount) {
        System.out.println("Mock Payment Gateway: Payment of $" + amount + " successful for Order #" + orderId);
        return true;
    }
}
