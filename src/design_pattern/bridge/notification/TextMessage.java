package design_pattern.bridge.notification;

import design_pattern.bridge.notification_sender.NotificationSender;

public class TextMessage extends Notification {

    public TextMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a text message.");
    }

    @Override
    public void sendMessage() {
        notificationSender.sendNotification();
    }
}
