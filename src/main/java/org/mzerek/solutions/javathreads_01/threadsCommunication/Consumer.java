package main.java.org.mzerek.solutions.javathreads_01.threadsCommunication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;

public class Consumer implements Runnable {

    private BlockingQueue<String> blockingQueue;
    private ResultBuffer resultBuffer;

    private int numOfProcessData = 0;
    private Map<String, Integer> map = new HashMap<>(10);

    public Consumer(BlockingQueue<String> blockingQueue, ResultBuffer resultBuffer) {
        this.blockingQueue = blockingQueue;
        this.resultBuffer = resultBuffer;
    }

    @Override
    public void run() {
        try {
            do {
                String element = blockingQueue.poll(100, TimeUnit.MILLISECONDS);
                if (element != null) {
                    resultBuffer.process(element);
                    numOfProcessData++;
                    Thread.sleep(20);
                }
            } while (true);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            //throw new RuntimeException(e);
        } finally {
            System.out.println("Thread: " + Thread.currentThread().getName() + " send: " + numOfProcessData );
        }

    }
}
