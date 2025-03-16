package org.interFace.project;

public class OrderManager {
    private final IOrderProcessor orderProcessor;
    private IPaymentGateway paymentGateway;

    public OrderManager(IOrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
        System.out.println("Order Manager initialized with Basic Order Processor.");
    }

    public void setPaymentGateway(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
        System.out.println("Payment Gateway set: " + paymentGateway.getClass().getSimpleName());
    }

    public void createOrder(int customerId, String items, double amount) {
        orderProcessor.createOrder(customerId, items, amount);
    }

    public boolean processPayment(int orderId, double amount ){
        if (paymentGateway == null){
            System.out.println("No payment gateway set order #" +orderId);
            return false;
        }
        boolean success = paymentGateway.processPayment(orderId, amount);
        if (success){
            ((BasicOrderProcessor)orderProcessor).updateStatus("paid");
        }
        return success;
    }
    public String getOrderStatus(int orderId){
        return orderProcessor.getOrderStatus(orderId);
    }
    public void confirmOrder(int orderId, INotificationService notificationService, String msg) {
        System.out.println("Confirming Order #" + orderId + " with " + notificationService.getClass().getSimpleName());
        String notificationResult = notificationService.sendNotification(orderId, msg);
        System.out.println(notificationResult);
        ((BasicOrderProcessor) orderProcessor).updateStatus("Confirmed"); // Casting for simplicity
    }
}
