package main.java.org.mzerek.solutions.javathreads_01.barrierpattern;

import main.java.org.mzerek.solutions.javathreads_01.DelayUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Calc2 implements Runnable {

    public static int calcTwoValue = 0;
    @Override
    public void run() {
        calcTwoValue = 7 + 8;
        //DelayUtils.delaySecond(4);
        try {
            MainCalc.barrier.await(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
