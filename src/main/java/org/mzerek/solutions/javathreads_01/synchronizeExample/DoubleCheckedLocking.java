package main.java.org.mzerek.solutions.javathreads_01.synchronizeExample;

public class DoubleCheckedLocking {

    private volatile static DoubleCheckedLocking instance;

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    public synchronized void print() {
        System.out.println("Caused by: " +
                Thread.currentThread().getName() +
                " hash: " + Integer.toHexString(hashCode()));
        System.out.flush();
    }
}
