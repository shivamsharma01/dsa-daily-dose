package design_pattern.observerpattern;

public interface StockObservable {
    void add(NotificationObserver notificationObserver);

    void remove(NotificationObserver notificationObserver);

    void notifySub();

    int getStockCount();

    void setStockCount(int stockCount);
}
