package org.mzerek.solutions.mystackimpl.mystackarray;

import org.junit.*;

import java.util.Arrays;

interface Stos {
    Integer peekFirst();

    Integer peekLast();

    void removeFirst();

    void removeLast();

    void addFirst(Integer object);

    void addLast(Integer object);

    void displayStos();

    public Integer[] getStosObjects();
}

class StosImpl implements Stos {
    private int maxStackSize = 0;
    private Integer[] objects = new Integer[maxStackSize];

    @Override
    public Integer peekFirst() {
        return objects[0];
    }

    @Override
    public Integer peekLast() {
        int size = objects.length;
        return objects[size - 1];
    }

    @Override
    public void removeFirst() {
        objects = Arrays.copyOfRange(objects, 1, objects.length);
    }

    @Override
    public void removeLast() {
        objects = Arrays.copyOfRange(objects, 0, objects.length - 1);
    }

    @Override
    public void addFirst(Integer object) {
        Integer[] newObjects = new Integer[objects.length + 1];
        newObjects[0] = object;
        System.arraycopy(objects, 0, newObjects, 1, objects.length);
        objects = newObjects;

    }

    @Override
    public void addLast(Integer object) {
        Integer[] newObjects = new Integer[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[objects.length] = object;
        objects = newObjects;
    }

    @Override
    public void displayStos() {
        for (Integer s : objects) {
            System.out.println(s);
        }
        System.out.println("=====================");
    }
    @Override
    public Integer[] getStosObjects() {
        return objects;
    }



}

public class StackArrayApp {

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



        //JUnitCore.main("Solution");

/*
        Result result = JUnitCore.runClasses(StackArrayApp.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());*/
    }

    @Test
    public void addFirstTest() {
        //is
        Stos stos = new StosImpl();
        stos.addFirst(5);
        stos.addFirst(8);
        stos.addFirst(2);
        //when
        Integer[] stosObjects = stos.getStosObjects();

        //expected
        Integer[] expectedStosObjects = {2, 8, 5};
        //stos.displayStos();

        Assert.assertArrayEquals(expectedStosObjects, stosObjects);
    }

    @Test
    public void addLastTest() {
        //is
        Stos stos = new StosImpl();
        stos.addFirst(5);
        stos.addFirst(8);
        stos.addLast(0);
        stos.addFirst(2);
        stos.addLast(12);
        //when
        Integer[] stosObjects = stos.getStosObjects();

        //expected
        Integer[] expectedStosObjects = {2, 8, 5, 0, 12};
        //stos.displayStos();

        Assert.assertArrayEquals(expectedStosObjects, stosObjects);
    }

    @Test
    public void peekFirstTest() {
        //is
        Stos stos = new StosImpl();
        stos.addFirst(5);
        stos.addFirst(8);
        stos.addLast(0);
        stos.addFirst(2);
        stos.addLast(12);
        //when
        Integer first = stos.peekFirst();

        //expected
        Integer expectedFirst = 2;
        //stos.displayStos();

        Assert.assertEquals(expectedFirst, first);
    }

    @Test
    public void peekLastTest() {
        //is
        Stos stos = new StosImpl();
        stos.addFirst(5);
        stos.addFirst(8);
        stos.addLast(0);
        stos.addFirst(2);
        stos.addLast(12);
        //when
        Integer last = stos.peekLast();

        //expected
        Integer expectedFirst = 12;
        //stos.displayStos();

        Assert.assertEquals(expectedFirst, last);
    }

    @Test
    public void removeFirstTest() {
        //is
        Stos stos = new StosImpl();
        stos.addFirst(5);
        stos.addFirst(8);
        stos.addLast(0);
        stos.addFirst(2);
        stos.addLast(12);
        //when
        stos.removeFirst();
        Integer[] stosObjects = stos.getStosObjects();

        //expected
        Integer[] expectedStosObjects = {8, 5, 0, 12};
        //stos.displayStos();

        Assert.assertArrayEquals(expectedStosObjects, stosObjects);
    }

    @Test
    public void removeLastTest() {
        //is
        Stos stos = new StosImpl();
        stos.addFirst(5);
        stos.addFirst(8);
        stos.addLast(0);
        stos.addFirst(2);
        stos.addLast(12);
        //when
        stos.removeLast();
        Integer[] stosObjects = stos.getStosObjects();

        //expected
        Integer[] expectedStosObjects = {2, 8, 5, 0};
        //stos.displayStos();

        Assert.assertArrayEquals(expectedStosObjects, stosObjects);
    }
}


