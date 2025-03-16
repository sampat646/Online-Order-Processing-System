package org.interFace.project;

public class BasicOrderProcessor implements  IOrderProcessor{
    private int orderId;
    private String status;
    @Override
    public void createOrder(
            int customerId, String items, double amount) {
        this.orderId = customerId * 1000 + 1;
        this.status = "Pending";
        System.out.println("Order #" + orderId + " created: " + items + " - Total: $" + amount);
    }

    @Override
    public String getOrderStatus(int orderId) {
        return "status :"+status;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
