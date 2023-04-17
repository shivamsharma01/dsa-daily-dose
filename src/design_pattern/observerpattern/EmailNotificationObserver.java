package design_pattern.observerpattern;

public class EmailNotificationObserver implements NotificationObserver {
    String emailId;
    StockObservable stockObservable;

    public EmailNotificationObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Mailing to " + emailId);
        System.out.println("Hurry up stocks are there");
        System.out.println("-----------------------------------------------");
    }
}
