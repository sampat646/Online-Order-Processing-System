package org.interFace.project;

public interface IOrderProcessor {
    void createOrder(int customerId, String items, double amount);
    String getOrderStatus(int orderId);
}
