package main.java.org.mzerek.solutions.javathreads_01.executors;

import java.util.concurrent.*;

//https://www.baeldung.com/java-future
public class ExecutorExamplev2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(new Callable<>() {
            @Override
            public Integer call() {
                return sumNumbers(10);
            }
        });
        int sum = future.get();
        System.out.println("Sum: " + sum);

        Future<Integer> future2 = executorService.submit(() -> sumNumbers(11));
        int sum2 = future2.get();
        System.out.println("Sum: " + sum2);

        int sum3 = future3(executorService, 12).get();
        System.out.println("Sum: " + sum3);

        executorService.shutdown();

    }

    public static Future<Integer> future3(ExecutorService executorService, Integer input) {
        return executorService.submit(() -> sumNumbers(input));
    }

    public static int sumNumbers(int countValue) {
        int sum = 0;
        for (int i = 0; i < countValue; i++) {
            sum = sum + 1;
        }
        return sum;
    }
}
