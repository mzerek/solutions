package main.java.org.mzerek.solutions.algorithms_03.sam_example;

//https://medium.com/@AlexanderObregon/pass-by-value-in-java-and-how-it-affects-object-references-d95cc74768bd
public class Example3 {
    public static void main(String[] args) {
        int a = 2;
        Integer aa = 22;

        System.out.println(a);
        System.out.println(aa);

        change(a, aa);

        System.out.println(a);
        System.out.println(aa);

        //=========Object example
        ObjectExample objectExample = new ObjectExample();
        objectExample.someValue = 123;
        System.out.println("someValue: " + objectExample.someValue);
        modifyObjectValue(objectExample);
        System.out.println("after someValue: " + objectExample.someValue);
    }

    private static void change(int b, Integer bb) {
        System.out.println(b);
        System.out.println(bb);

        b = 5;
        bb = 55;

        System.out.println("After" + b);
        System.out.println("After" + bb);
    }

    private static void modifyObjectValue(ObjectExample objectExample){
        objectExample.someValue = 100;
    }

    private static class ObjectExample {
        int someValue;
    }
}
