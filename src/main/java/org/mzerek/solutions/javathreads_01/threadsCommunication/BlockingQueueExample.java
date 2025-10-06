package main.java.org.mzerek.solutions.javathreads_01.threadsCommunication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;
import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;

public class BlockingQueueExample {

    //https://www.baeldung.com/java-blocking-queue
    public static void main(String[] args) {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(20);
        ResultBuffer resultBuffer = new ResultBuffer();

        Thread producer1 = new Thread(new Producer(arrayBlockingQueue, "P1"));
        producer1.setName("P1");
        Thread producer2 = new Thread(new Producer(arrayBlockingQueue, "P2"));
        producer2.setName("P2");
        Thread producer3 = new Thread(new Producer(arrayBlockingQueue, "P3"));
        producer3.setName("P3");

        Thread consumer1 = new Thread(new Consumer(arrayBlockingQueue, resultBuffer));
        consumer1.setName("C1");
        Thread consumer2 = new Thread(new Consumer(arrayBlockingQueue, resultBuffer));
        consumer2.setName("C2");
        Thread consumer3 = new Thread(new Consumer(arrayBlockingQueue, resultBuffer));
        consumer3.setName("C3");
        Thread consumer4 = new Thread(new Consumer(arrayBlockingQueue, resultBuffer));
        consumer4.setName("C4");

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

        delaySecond(2);

        producer1.interrupt();
        producer2.interrupt();
        producer3.interrupt();

        delay(100);

        do {
            resultBuffer.printResult();
            delaySecond(1);
        }
        while (producer1.isAlive() || producer2.isAlive() || producer3.isAlive());
    }
}
