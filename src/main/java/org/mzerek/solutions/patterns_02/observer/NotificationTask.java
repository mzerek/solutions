package main.java.org.mzerek.solutions.patterns_02.observer;

public class NotificationTask implements Observer {

    @Override
    public void notification() {
        String threadName = Thread.currentThread().getName();
        System.out.println("End of task >> " + threadName);
    }
}
