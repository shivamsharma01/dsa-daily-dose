package design_pattern.bridge;

import design_pattern.bridge.notification.Notification;
import design_pattern.bridge.notification.TextMessage;
import design_pattern.bridge.notification_sender.Email;

public class BridgeMain {
    public static void main(String[] args) {
        Notification textMessage = new TextMessage(new Email());
        textMessage.sendMessage();
    }
}
