package main.java.org.mzerek.solutions.javathreads_01.threadsCommunication;

import java.util.HashMap;
import java.util.Map;

public class ResultBuffer {
    private Map<String, Integer> map = new HashMap<>(10);

    public synchronized void process(String name) {
        int counter = 0;
        if (map.containsKey(name)) {
            counter = map.get(name);
        }
        counter++;
        map.put(name, counter);
    }

    public void printResult() {
        System.out.println("Result: " + map.toString());
    }
}
