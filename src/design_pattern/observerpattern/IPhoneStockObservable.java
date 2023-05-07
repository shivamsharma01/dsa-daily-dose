package design_pattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObservable implements StockObservable {

    private final List<NotificationObserver> notificationObserverList = new ArrayList<>();
    private int stockCount;

    @Override
    public void add(NotificationObserver notificationObserver) {
        notificationObserverList.add(notificationObserver);
    }

    @Override
    public void remove(NotificationObserver notificationObserver) {
        notificationObserverList.remove(notificationObserver);
    }

    @Override
    public void notifySub() {
        notificationObserverList.forEach(NotificationObserver::update);
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public void setStockCount(int newStock) {
        if (stockCount == 0) {
            notifySub();
        }
        stockCount += newStock;
    }
}
