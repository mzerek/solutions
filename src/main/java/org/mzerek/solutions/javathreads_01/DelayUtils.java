package main.java.org.mzerek.solutions.javathreads_01;

public class DelayUtils {

    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
