package main.java.org.mzerek.solutions.patterns_02.observer;

public class TaskForObservation {

    public TaskForObservation(Observer observer) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " >> " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            observer.notification();
        });
        thread.setName("ObservedTask");
        thread.start();
    }
}
