package design_pattern.bridge.notification_sender;

public class Email implements NotificationSender {

    @Override
    public void sendNotification() {
        System.out.println("Sending an email.");
    }
}
