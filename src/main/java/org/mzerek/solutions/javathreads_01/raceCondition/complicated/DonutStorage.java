package main.java.org.mzerek.solutions.javathreads_01.raceCondition.complicated;

public class DonutStorage {

    private int donutsNumber;

    public DonutStorage(int donutsNumber) {
        this.donutsNumber = donutsNumber;
    }

    public int getDonutsNumber() {
        return donutsNumber;
    }

    public void setDonutsNumber(int donutsNumber) {
        this.donutsNumber = donutsNumber;
    }
}
