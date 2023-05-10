package org.mzerek.solutions.mystacklist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

interface Stos {
    Integer peekFirst();

    Integer peekLast();

    void removeFirst();

    void removeLast();

    void addFirst(Integer object);

    void addLast(Integer object);

    void displayStos();
}

class StosImpl implements Stos {

    private List<Integer> objects = new LinkedList<>();

    @Override
    public Integer peekFirst() {
        return objects.get(0);
    }

    @Override
    public Integer peekLast() {
        int size = objects.size();
        return objects.get(size - 1);
    }

    @Override
    public void removeFirst() {
        objects.remove(0);
    }

    @Override
    public void removeLast() {
        int size = objects.size();
        objects.remove(size - 1);
    }

    @Override
    public void addFirst(Integer object) {
        objects.add(0, object);
    }

    @Override
    public void addLast(Integer object) {
        objects.add(object);
    }

    @Override
    public void displayStos() {
        objects.forEach(object -> System.out.println(object + ", "));
        System.out.println("=====================");
    }

}


public class StackApp {
    public static void main(String[] args) {
        Stos stos = new StosImpl();
        stos.addFirst(3);
        stos.displayStos();
        stos.addFirst(2);
        stos.displayStos();
        stos.addLast(4);
        stos.displayStos();
        stos.addFirst(8);
        stos.addLast(1);
        stos.displayStos();

        System.out.println("Pierwszy: " + stos.peekFirst());
        System.out.println("Ostatni: " + stos.peekLast());

        stos.removeFirst();
        stos.removeLast();

        System.out.println("Pierwszy: " + stos.peekFirst());
        System.out.println("Ostatni: " + stos.peekLast());

        stos.displayStos();


        String[] stringArray = {"foo", "bar", "baz"};
        String[] modifiedArray = Arrays.copyOfRange(stringArray, 1, stringArray.length);

        for(String s: stringArray){
            System.out.println(s);
        }

        for(String s: modifiedArray){
            System.out.println(s);
        }
    }

}
