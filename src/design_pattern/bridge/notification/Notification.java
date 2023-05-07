package design_pattern.bridge.notification;

import design_pattern.bridge.notification_sender.NotificationSender;

public abstract class Notification {
    final NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public abstract void sendMessage();
}
