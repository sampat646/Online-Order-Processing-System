package org.interFace.project;

public class SmsNotification implements INotificationService{
    @Override
    public String sendNotification(int orderId, String message) {
        return message+" "+orderId;
    }
}
