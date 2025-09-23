package main.java.org.mzerek.solutions.javathreads_01.raceCondition.complicated;

public class Consumer {

    private final DonutStorage donutStorage;

    public Consumer(DonutStorage donutStorage) {
        this.donutStorage = donutStorage;
    }

    public void consume(int numberOfDonutsToConsume) {
        donutStorage.setDonutsNumber(donutStorage.getDonutsNumber() - numberOfDonutsToConsume);
    }
}
