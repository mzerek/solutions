package main.java.org.mzerek.solutions.javathreads_01.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;


/*
https://www.youtube.com/watch?v=xlkSa44Mdz8
 */
public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> futureOrderProcessor = Executors.newSingleThreadExecutor().submit(() -> {
            System.out.println("Begin - order processing");
            delaySecond(5);
            System.out.println("End - order processing");
            return "Order no 1";
        });

        while(!futureOrderProcessor.isDone()){
            System.out.println("Doing something else");
            delaySecond(1);
        }

        String result = futureOrderProcessor.get();
        System.out.println("Processed order result: " + result);
    }
}
