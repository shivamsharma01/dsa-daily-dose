package design_pattern.observerpattern;

public class ECommerceSite {

    public static void main(String[] args) {
        StockObservable stockObservable = new IPhoneStockObservable();
        NotificationObserver observer1 = new EmailNotificationObserver("akash@gmail.com", stockObservable);
        NotificationObserver observer2 = new EmailNotificationObserver("shivam@gmail.com", stockObservable);
        NotificationObserver observer3 = new PhoneNotificationObserver("9289599335", stockObservable);
        NotificationObserver observer4 = new PhoneNotificationObserver("6578990809", stockObservable);
        stockObservable.add(observer1);
        stockObservable.add(observer2);
        stockObservable.add(observer3);
        stockObservable.add(observer4);
        stockObservable.setStockCount(10);
    }

}
