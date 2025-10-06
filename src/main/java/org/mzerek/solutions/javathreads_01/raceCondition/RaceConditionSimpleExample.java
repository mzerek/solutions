package main.java.org.mzerek.solutions.javathreads_01.raceCondition;

import java.util.concurrent.atomic.AtomicInteger;

//https://kubawasikowski.com/czym-jest-warunek-wyscigu-race-condition-w-programowaniu/
public class RaceConditionSimpleExample {
    // Współdzielony licznik
    private static int counter = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    incrementCounter(); // Inkrementacja licznika
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    incrementCounter(); // Inkrementacja licznika
                }
            }
        });

        t1.setName("T1");
        t2.setName("T2");

        t1.start(); // Start pierwszego wątku
        t2.start(); // Start drugiego wątku

        try {
            t1.join(); // Oczekiwanie na zakończenie t1
            t2.join(); // Oczekiwanie na zakończenie t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wypisanie końcowej wartości licznika
        System.out.println("Counter: " + counter);
        System.out.println("Atomic Counter: " + atomicInteger.get());
    }

    // Metoda do inkrementacji licznika
    //private synchronized static void incrementCounter() {
    private static void incrementCounter() {
        // Tutaj występuje warunek wyścigu
        //System.out.println("incrementCounter Thread name: " + Thread.currentThread().getName());
        counter++;
        atomicInteger.addAndGet(1);
        //System.out.println("incrementCounter counter: " + counter);
        //System.out.println("incrementCounter atomicInteger: " + atomicInteger.get());
    }
}
