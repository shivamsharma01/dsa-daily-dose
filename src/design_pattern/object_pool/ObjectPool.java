package design_pattern.object_pool;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {
    final long deadTime;

    final Hashtable<T, Long> lock;
    final Hashtable<T, Long> unlock;

    ObjectPool() {
        deadTime = 50000; // 50 seconds
        lock = new Hashtable<>();
        unlock = new Hashtable<>();
    }

    abstract T create();

    abstract boolean validate(T o);

    abstract void dead(T o);

    synchronized T takeOut() {
        long now = System.currentTimeMillis();
        T t;
        if (unlock.size() > 0) {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unlock.get(t)) > deadTime || !validate(t)) {
                    // dead condition true
                    unlock.remove(t);
                    dead(t);
                    t = null;
                } else {
                    unlock.remove(t);
                    lock.put(t, now);
                    return (t);
                }
            }
        }
        // no objects available, create a new one
        t = create();
        lock.put(t, now);
        return (t);
    }

    synchronized void takeIn(T t) {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }

}