package main.java.org.mzerek.solutions.algorithms_03.power;

public class PowerExample {

    public static void main(String[] args) {
        long value = 4;
        long power = 5;
        long powerValue = makePower(value, power);
        System.out.println("Power result: " + powerValue);
;
        long powerValueRecursion= makePowerRecursion(value, power);
        System.out.println("Power result recursion: " + powerValueRecursion);
    }

    private static long makePowerRecursion(long value, long power) {
        if(power == 0) {
            return 1;
        }
        return value * makePowerRecursion(value, power-1);
    }

    public static long makePower(long value, long power) {
        long powerValue = 1;
        for(int i=0; i<power; i++) {
            powerValue = value * powerValue;
        }
        return powerValue;
    }
}
