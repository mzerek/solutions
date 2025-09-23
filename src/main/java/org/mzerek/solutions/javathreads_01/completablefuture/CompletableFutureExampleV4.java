package main.java.org.mzerek.solutions.javathreads_01.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delaySecond;


/*
https://dev.to/danielrendox/thread-runnable-callable-executorservice-and-future-all-the-ways-to-create-threads-in-java-2o86
 */
public class CompletableFutureExampleV4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] names = {"Daniel", "Mary", "Alex", "Andrew"};

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
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
        });
/*
        CompletableFuture.allOf(completableFuture)
                        .thenApply(__ -> completableFuture.join());

        completableFuture.join();*/

        completableFuture.thenAcceptAsync(name -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
            System.out.println("Now I'm going to print you the name");
            System.out.println("Result: " + name);
        });


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
