package design_pattern.singleton;

public class Singleton {

    // volatile helps overcome the race condition in a multithreaded environment
    private static volatile Singleton singleton = null;

    private Singleton() {
        // useful if reflection is used to bypass the accessibility (private/public)
        if (singleton != null) {
            throw new RuntimeException("Exception !!!!");
        }
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            // Single instance throughout the application level
            synchronized (Singleton.class) {
                // inner null check is necessary
                // suppose before any thread actually initializes the singleton variable below,
                // multiple threads have got true for singleton == null
                // then without the inner null check, they all will be able to create a new instance
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
