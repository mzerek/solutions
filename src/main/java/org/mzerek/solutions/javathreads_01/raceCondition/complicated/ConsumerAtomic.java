package main.java.org.mzerek.solutions.javathreads_01.raceCondition.complicated;

import java.util.concurrent.atomic.AtomicInteger;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;

public class ConsumerAtomic {

    private final DonutStorageAtomic donutStorage;

    public ConsumerAtomic(DonutStorageAtomic donutStorage) {
        this.donutStorage = donutStorage;
    }

    public int consume(int numberOfDonutsToConsume) {
        synchronized (donutStorage) {
            AtomicInteger donutsNumber = donutStorage.getDonutsNumber();
            if (numberOfDonutsToConsume > donutsNumber.get()) {
                int result = donutsNumber.get();
                donutsNumber.set(0);
                return result;
            }

            // printing some random text or delay breaks the program
            System.out.println("Random text");
            delay(1);

            donutStorage.getDonutsNumber().addAndGet(-numberOfDonutsToConsume);
            return numberOfDonutsToConsume;
        }
    }
}
