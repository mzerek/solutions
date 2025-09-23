package main.java.org.mzerek.solutions.javathreads_01.states;

public class StatesExample {

    public static void main(String[] args) throws InterruptedException {

        Thread someThread = new Thread(StatesExample::someJob);
        System.out.println(someThread.getState());

        someThread.start();
        System.out.println(someThread.getState());

        Thread.sleep(100);
        System.out.println(someThread.getState());

        someThread.join();
        System.out.println(someThread.getState());
    }

    public static void someJob() {
        long start = System.currentTimeMillis();
        long stop = start + 100;
        while (System.currentTimeMillis() < stop) {
           // System.out.println("in while");
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
