package main.java.org.mzerek.solutions.treemap_06;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {

    public static void main(String[] args) {

        TreeMap<Person, Integer> personaTreeMap = new TreeMap<>(Comparator.comparingInt(v -> v.age));
        personaTreeMap.put(new Person("John", "Smith", 17), 0);
        personaTreeMap.put(new Person("Ivan", "Petrenko", 65), 0);
        personaTreeMap.put(new Person("Pedro", "Escobar", 32), 0);
        personaTreeMap.put(new Person("Shirley", "Hatfield", 14), 0);
        personaTreeMap.put(new Person("Abby", "Parsons", 19), 0);

        Person findAdultPerson = personaTreeMap
                .navigableKeySet().stream()
                .filter(person -> person.age>18)
                .findFirst()
                .get();

        Map<Person, Integer> youngPeopleMap = personaTreeMap.headMap(findAdultPerson, false);
        Map<Person, Integer> adultPeopleMap = personaTreeMap.tailMap(findAdultPerson, true);

        youngPeopleMap.forEach((person, integer) -> System.out.println("Young: " + person.firstName));
        adultPeopleMap.forEach((person, integer) -> System.out.println("Adult: " + person.firstName));
    }
}
