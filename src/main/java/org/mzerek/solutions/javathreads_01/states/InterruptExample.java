package main.java.org.mzerek.solutions.javathreads_01.states;

import java.time.LocalDateTime;

public class InterruptExample {

    public static void main(String[] args) throws InterruptedException {
        Thread someThread = new Thread(InterruptExample::sleepWell);
        someThread.start();
        System.out.println(someThread.getState());
        someThread.interrupt();
    }

    public static void sleepWell() {
        try {
            System.out.println("Sleep started at: " + LocalDateTime.now());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("System was interrupted");
        } finally {
            System.out.println("Sleep finished at: " + LocalDateTime.now());
        }
    }
}

