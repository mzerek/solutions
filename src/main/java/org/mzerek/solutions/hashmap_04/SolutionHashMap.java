package main.java.org.mzerek.solutions.hashmap_04;

//https://www.turing.com/kb/implementing-hashmap-in-java


import java.util.HashMap;
import java.util.Map;

public class SolutionHashMap {
    public static void main(String[] args) {
        /*
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

        myHashMap.put(2, "Drugi");
        myHashMap.put(3, "Trzeci");
        myHashMap.put(4, "Czwarty");

        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(4));

        myHashMap.remove(3);
        System.out.println(myHashMap.get(3));
        */

/*        MyHashMap<String, String> ssMap= new MyHashMap<>();
        String one = "One";
        String onex = new String("One");
        ssMap.put(one, "Maciek");
        ssMap.put(onex, "Franek");
        ssMap.put("Two", "Tola");*/

        MyHashMap<MyCollisionKey, String> ssMap= new MyHashMap<>();
        MyCollisionKey one = new MyCollisionKey(2, "Maciek");
        MyCollisionKey two = new MyCollisionKey(2, "Tomek");
        MyCollisionKey three = new MyCollisionKey(3, "Tola");
        ssMap.put(one, "Maciek");
        ssMap.put(two, "Franek");
        ssMap.put(three, "Tola");

        System.out.println(ssMap.get(one));
        System.out.println(ssMap.get(two));

        Map<String, String> tmp = new HashMap<>();
    }
}
