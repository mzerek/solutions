package main.java.org.mzerek.solutions.javathreads_01.completablefuture;

import java.util.concurrent.CompletableFuture;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;

public class OrderProcessor {

    public CompletableFuture<String> processOrder(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Begin - order processing");
            delaySecond(5);
            System.out.println("End - order processing");
            return "Order no 1";
        });
    }
}
