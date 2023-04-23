package design_pattern.bridge.notification;

import design_pattern.bridge.notification_sender.NotificationSender;

public class QRMessage extends Notification {

    public QRMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is the QR Code.");
    }

    @Override
    public void sendMessage() {
        // call some method to build qr code. The main thing to note is sendMessage of this class can be different from other sendMessage implementations like TextMessage
        notificationSender.sendNotification();
    }

}
