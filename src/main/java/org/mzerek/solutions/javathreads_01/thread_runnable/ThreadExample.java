package main.java.org.mzerek.solutions.javathreads_01.thread_runnable;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("Inside thread T0");
        System.out.println("T0 start");
        for (int i =0; i<5; i++){
            System.out.println("T0 " + i);
        }
        System.out.println("T0 stop");
    }
}