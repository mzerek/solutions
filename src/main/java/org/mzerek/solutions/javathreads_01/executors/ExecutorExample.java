package main.java.org.mzerek.solutions.javathreads_01.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
https://www.youtube.com/watch?v=xlkSa44Mdz8
 */
public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> numbers());
        executorService.submit(() -> numbers());
        executorService.submit(() -> numbers()); // when one of the two previous tasks is completed
        executorService.shutdown();

    }

    public static void numbers() {
        for(int i=0; i<999;i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
