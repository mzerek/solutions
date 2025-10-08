package main.java.org.mzerek.solutions.javathreads_01.collectThread;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;

public class CollectThreadExample {

    public static void main(String[] args) {

        CollectThreadExample example = new CollectThreadExample();

        long startTime = System.currentTimeMillis();

        var one = example.one();
        var two = example.two();
        var three = example.three();
        var four = example.four();
        var five = example.five();

        System.out.println(one + " - " + two + " - " + three + " - " + four + " - " + five);
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    public int one() {
        delaySecond(1);
        return 1;
    }

    public int two() {
        delaySecond(2);
        return 2;
    }

    public int three() {
        delaySecond(3);
        return 3;
    }

    public int four() {
        delaySecond(4);
        return 4;
    }

    public int five() {
        delaySecond(5);
        return 5;
    }
}
