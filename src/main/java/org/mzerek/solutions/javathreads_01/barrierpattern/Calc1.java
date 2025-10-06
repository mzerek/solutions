package main.java.org.mzerek.solutions.javathreads_01.barrierpattern;

import main.java.org.mzerek.solutions.javathreads_01.DelayUtils;

import java.util.concurrent.BrokenBarrierException;

public class Calc1 implements Runnable {

    public static int calcOneValue = 0;
    @Override
    public void run() {
        calcOneValue = 4 * 5;
        //DelayUtils.delaySecond(2);
        try {
            MainCalc.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
