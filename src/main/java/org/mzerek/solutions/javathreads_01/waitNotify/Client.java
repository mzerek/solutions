package main.java.org.mzerek.solutions.javathreads_01.waitNotify;

import static main.java.org.mzerek.solutions.javathreads_01.DelayUtils.delay;

public class Client implements Runnable {

    private Market market;

    public Client(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Client get: " + i);
            market.get();
        }
    }
}
