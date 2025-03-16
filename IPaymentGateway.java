package org.interFace.project;

public interface IPaymentGateway {
    boolean processPayment(int orderId, double amount);
}
