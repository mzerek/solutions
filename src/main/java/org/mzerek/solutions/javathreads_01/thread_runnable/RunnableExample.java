package main.java.org.mzerek.solutions.javathreads_01.thread_runnable;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside thread T3");
        System.out.println("T3 start");
        for (int i =0; i<5; i++){
            System.out.println("T3 " + i);
        }
        System.out.println("T3 stop");
    }
}