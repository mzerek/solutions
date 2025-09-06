package main.java.org.mzerek.solutions.javathreads_01.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;


/*
https://www.youtube.com/watch?v=xlkSa44Mdz8
 */
public class CompletableFutureExampleV3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> calc1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculation #1 in progress");
            delay(4);
            int result = (new Random()).nextInt(1000);
            System.out.println("Calc1 result is " + result);
            return result;
        });

        CompletableFuture<Integer> calc2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculation #2 in progress");
            delay(1);
            int result = (new Random()).nextInt(10);
            System.out.println("Calc2 result is " + result);
            return result;
        });

        calc1.thenCombine(calc2, (c1, c2) -> c1 * c2)
                .thenAccept(result -> System.out.println("Combination result is " + result))
                .get();
    }
}
