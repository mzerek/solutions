package main.java.org.mzerek.solutions.javathreads_01.waitNotify;


//https://codegym.cc/pl/groups/posts/pl.859.metoda-wait-w-javie
public class Example {

    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Client client = new Client(market);

        Thread tp = new Thread(producer);
        tp.setName("producer");
        tp.start();

        Thread tc =new Thread(client);
        tc.setName("client");
        tc.start();
    }
}
