package main.java.org.mzerek.solutions.javathreads_01.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.atomic.AtomicInteger;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;


/*
https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/concurrent/CompletableFuture.html#runAsync%28java.lang.Runnable,java.util.concurrent.Executor%29
https://stackoverflow.com/questions/59376112/naming-thread-of-completablefuture
https://www.callicoder.com/java-8-completablefuture-tutorial/
 */
public class CompletableFutureExampleV5 {

    private static final AtomicInteger threadCounter = new AtomicInteger();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] names = {"Daniel", "Mary", "Alex", "Andrew"};

        ForkJoinPool.ForkJoinWorkerThreadFactory factory = pool -> {
            ForkJoinWorkerThread thread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            thread.setName("Mzerek thread: " + threadCounter.incrementAndGet());
            return thread;
        };

        //Executor
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors(),
                factory, null, false);

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Hello from " + Thread.currentThread().getName());
                    System.out.println("I'll give you the name in 5 sec");
                    for (int i = 5; i > 0; i--){
                        System.out.println(i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("Exception while sleeping in " + Thread.currentThread().getName());
                            e.printStackTrace();
                        }
                    }
                    return randomElement(names);
                    }, forkJoinPool)
                .thenAcceptAsync(name -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
            System.out.println("Now I'm going to print you the name");
            System.out.println("Result: " + name);
        }, forkJoinPool);

        CompletableFuture<Integer> calc1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculation #1 in progress");
            System.out.println("Calculation #1 from " + Thread.currentThread().getName());
            delaySecond(4);
            int result = (new Random()).nextInt(1000);
            System.out.println("Calc1 result is " + result);
            return result;
        }, forkJoinPool);

        CompletableFuture<Integer> calc2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculation #2 in progress");
            System.out.println("Calculation #2 from " + Thread.currentThread().getName());
            delaySecond(1);
            int result = (new Random()).nextInt(10);
            System.out.println("Calc2 result is " + result);
            return result;
        }, forkJoinPool);

        calc1.thenCombine(calc2, (c1, c2) -> c1 * c2)
                .thenAccept(result -> System.out.println("Combination result is " + result))
                .get();


        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Exception while sleeping in " + Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

    private static String randomElement(String[] array) {
        return array[new Random().nextInt(array.length)];
    }
}
