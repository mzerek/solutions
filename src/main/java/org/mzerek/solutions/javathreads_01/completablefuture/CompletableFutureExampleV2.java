package main.java.org.mzerek.solutions.javathreads_01.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;


/*
https://www.youtube.com/watch?v=xlkSa44Mdz8
 */
public class CompletableFutureExampleV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrderProcessor orderProcessor = new OrderProcessor();
        CompletableFuture<Void> futureOrder = orderProcessor.processOrder()
                .thenApply(String::toUpperCase)
                .thenApply(message -> {
                    throw new RuntimeException("Cannot process order");
                })
                .exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return "Error";
                })
                .thenAccept(message -> System.out.println("Processed order result: " + message));

        while(!futureOrder.isDone()){
            System.out.println("Doing something else");
            delay(1);
        }

        futureOrder.get();
    }
}
