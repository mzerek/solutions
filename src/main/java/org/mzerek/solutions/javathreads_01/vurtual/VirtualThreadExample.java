package main.java.org.mzerek.solutions.javathreads_01.vurtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        IntStream.range(0, 10).forEach(i -> {
            executor.submit(() -> {
                System.out.println("Task " + i + " running on: " + Thread.currentThread().threadId());
                try {
                    Thread.sleep(500); // Simulating a task
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        });

        executor.shutdown();

        Thread.sleep(5000);
    }
}
