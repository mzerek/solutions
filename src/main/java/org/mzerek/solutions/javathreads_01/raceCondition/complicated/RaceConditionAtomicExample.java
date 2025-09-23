package main.java.org.mzerek.solutions.javathreads_01.raceCondition.complicated;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

//https://dev.to/danielrendox/what-are-race-conditions-in-java-and-how-to-solve-them-with-synchronized-and-atomicinteger-111m#problem-1
public class RaceConditionAtomicExample {

    public static void main(String[] args) {
        int consumersNumber = 10;
        DonutStorageAtomic donutStorage = new DonutStorageAtomic(new AtomicInteger(20));
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<?>> futures = new ArrayList<>(consumersNumber);

        for (int i = 0; i < consumersNumber; i++) {
            futures.add(executorService.submit(() -> {
                ConsumerAtomic consumer = new ConsumerAtomic(donutStorage);
                System.out.println(Thread.currentThread().getName() + " consumed " +
                        consumer.consume(3));

            }));
        }
        executorService.shutdown();

        //wrong value: "Number of remaining donuts: 20", main thread not waiting for other threads
        // make the main thread wait for others to finish
        for(Future<?> future: futures){
            try {
                future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Number of remaining donuts: " + donutStorage.getDonutsNumber());


    }
}
