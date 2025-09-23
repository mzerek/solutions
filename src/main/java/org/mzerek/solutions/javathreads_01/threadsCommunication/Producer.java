package main.java.org.mzerek.solutions.javathreads_01.threadsCommunication;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;

public class Producer implements Runnable {

    private BlockingQueue<String> blockingQueue;
    private int numOfSendData = 0;
    private String name;

    public Producer(BlockingQueue<String> blockingQueue, String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            do {
                numOfSendData++;
                blockingQueue.put(name);
                Thread.sleep((long) (10 + Math.random() * 10));
            } while (true);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            //throw new RuntimeException(e);
        } finally {
            System.out.println("Thread: " + Thread.currentThread().getName() + " send: " + numOfSendData);
        }
    }
}
