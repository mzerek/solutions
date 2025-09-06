package main.java.org.mzerek.solutions.javathreads_01.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;


/*
https://www.youtube.com/watch?v=xlkSa44Mdz8
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrderProcessor orderProcessor = new OrderProcessor();
        CompletableFuture<String> futureOrder = orderProcessor.processOrder()
                .thenApply(String::toUpperCase);

        while(!futureOrder.isDone()){
            System.out.println("Doing something else");
            delay(1);
        }

        String result = futureOrder.get();
        System.out.println("Processed order result: " + result);
    }
}
