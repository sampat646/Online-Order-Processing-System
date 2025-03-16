package org.interFace.project;

public class StripePaymentGateway implements  IPaymentGateway{
    @Override
    public boolean processPayment(int orderId, double amount) {
        System.out.println("strip Payment Gateway: Payment of $" + amount + " successful for Order #" + orderId);
        return true;
    }
}
