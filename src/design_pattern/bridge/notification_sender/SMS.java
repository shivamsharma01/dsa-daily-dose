package design_pattern.bridge.notification_sender;

public class SMS implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("We are going to send an SMS.");
    }
}
