package org.interFace.project;

public class Main {
    public static void main(String[] args) {
      OrderManager orderManager = new OrderManager(new BasicOrderProcessor());

      orderManager.createOrder(123,"shirt, shoes", 75.00);
      System.out.println(orderManager.getOrderStatus(123002));

      orderManager.setPaymentGateway(new MockPaymentGateway());
      orderManager.processPayment(123002,75.00);
      System.out.println(orderManager.getOrderStatus(123002));

      orderManager.confirmOrder(120032, new EmailNotification(),
              "Order #123001 confirmed! Your items will ship soon.");
      System.out.println(orderManager.getOrderStatus(123001));


    }
}
