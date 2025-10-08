package main.java.org.mzerek.solutions.javathreads_01.collectThread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;

public class CollectThreadExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CollectThreadExample3 example = new CollectThreadExample3();

        long startTime = System.currentTimeMillis();

        CompletableFuture<Integer> calc1 = CompletableFuture.supplyAsync(example::one);
        CompletableFuture<Integer> calc2 = CompletableFuture.supplyAsync(example::two);
        CompletableFuture<Integer> calc3 = CompletableFuture.supplyAsync(example::three);
        CompletableFuture<Integer> calc4 = CompletableFuture.supplyAsync(example::four);
        CompletableFuture<Integer> calc5 = CompletableFuture.supplyAsync(example::five);

        //https://medium.com/@AlexanderObregon/javas-completablefuture-allof-explained-0a032b657541
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(calc1, calc2, calc3, calc4, calc5);

        CompletableFuture<List<Integer>> allResults =
                allFuture.thenApply(result ->
                        Stream.of(calc1, calc2, calc3, calc4, calc5)
                                .map(CompletableFuture::join)
                                .collect(Collectors.toList()));

        List<Integer> results = allResults.get();
        System.out.println(
                results.get(0) + " - " + results.get(1) + " - " + results.get(2) + " - " + results.get(3) + " - " + results.get(4));
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");Stream<CompletableFuture<Integer>> fs = Stream.of(calc1, calc2, calc3, calc4, calc5);
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
