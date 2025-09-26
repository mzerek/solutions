package main.java.org.mzerek.solutions.algorithms_03.reverse;

import java.util.Arrays;

public class ReverseExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] integers = new Integer[array.length];
        Arrays.setAll(integers, i -> array[i]);
        System.out.println("Normal int list: " + Arrays.toString(array));
        System.out.println("Reversed int list: " + Arrays.toString(reverseArray(integers, array.length)));

        String[] stringArray = {"A","B", "C", "D", "E", "F", "H","I", "J"};
        System.out.println("Normal string list: " + stringArray);
        System.out.println("Reversed string list: " + Arrays.toString(reverseArray(stringArray, array.length)));

        Animal[] animalsArray = {new Animal("Cat"),new Animal("Dog"),
                new Animal("Duck"), new Animal("Bird"), new Animal("Shark")};
        Arrays.stream(animalsArray).forEach(animal -> System.out.println(animal.getAnimalName()));

        Object[] reversedAnimals = reverseArray(animalsArray, animalsArray.length);
        Arrays.stream(reversedAnimals)
                .forEach(animal -> System.out.println(((Animal) animal).getAnimalName()));
    }
    public static Object[] reverseArray(Object[] array, int length) {
        Object[] reversedArray = new Object[length];
        for(int i=0; i<length; i++){
            reversedArray[(length-1)-i] = array[i];
        }
        return reversedArray;
    }
}
