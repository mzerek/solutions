package main.java.org.mzerek.solutions.javathreads_01.collectThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;

public class CollectThreadExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CollectThreadExample2 example = new CollectThreadExample2();

        long startTime = System.currentTimeMillis();

        CompletableFuture<Integer> calc1 = CompletableFuture.supplyAsync(() -> {
            return example.one();
        });

        CompletableFuture<Integer> calc2 = CompletableFuture.supplyAsync(() -> {
            return example.two();
        });

        CompletableFuture<Integer> calc3 = CompletableFuture.supplyAsync(() -> {
            return example.three();
        });

        CompletableFuture<Integer> calc4 = CompletableFuture.supplyAsync(() -> {
            return example.four();
        });

        CompletableFuture<Integer> calc5 = CompletableFuture.supplyAsync(() -> {
            return example.five();
        });

        //https://medium.com/@AlexanderObregon/javas-completablefuture-allof-explained-0a032b657541
        CompletableFuture<Void> all = CompletableFuture.allOf(calc1, calc2, calc3, calc4, calc5)
                .thenRun(() -> {
                    try {
                        var one = calc1.get();
                        var two = calc2.get();
                        var three = calc3.get();
                        var four = calc4.get();
                        var five = calc5.get();
                        System.out.println("All tasks completed:");
                        System.out.println(one + " - " + two + " - " + three + " - " + four + " - " + five);
                        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
        all.get();

/*        var one = calc1.get();
        var two = calc2.get();
        var three = calc3.get();
        var four = calc4.get();
        var five = calc5.get();

        System.out.println(one + " - " + two + " - " + three + " - " + four + " - " + five);
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");*/
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
