package design_pattern.observerpattern;

public class PhoneNotificationObserver implements NotificationObserver {
    final String phoneNo;
    final StockObservable stockObservable;

    public PhoneNotificationObserver(String phoneNo, StockObservable observable) {
        this.phoneNo = phoneNo;
        this.stockObservable = observable;
    }

    @Override
    public void update() {
        System.out.println("Notifying on phone " + phoneNo);
        System.out.println("Hurry up " + stockObservable.getClass());
        System.out.println("-----------------------------------------------");
    }
}
