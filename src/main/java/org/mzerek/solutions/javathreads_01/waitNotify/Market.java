package main.java.org.mzerek.solutions.javathreads_01.waitNotify;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;

public class Market {

    private int item = 0;

    public synchronized void get() {
        while(item < 1) {
            try {
                System.out.println("while get: " + item);
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        item--;
        System.out.println("A client has bought 1 item...");
        System.out.println("Items quantity in Market warehouse... " + item);
        notify();
    }

    public synchronized void put(){
        while(item >= 6) {
            try {
                System.out.println("while put: " + item);
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        item ++;
        System.out.println("Manufacturer has added 1 more item...");
        System.out.println("Now there are " + item + " items in Warehouse" );
        notify();
    }
}
