package main.java.org.mzerek.solutions.javathreads_01.raceCondition.complicated;

import java.util.concurrent.atomic.AtomicInteger;

public class DonutStorageAtomic {

    private final AtomicInteger donutsNumber;

    public DonutStorageAtomic(AtomicInteger donutsNumber) {
        this.donutsNumber = donutsNumber;
    }

    public AtomicInteger getDonutsNumber() {
        return donutsNumber;
    }
}
