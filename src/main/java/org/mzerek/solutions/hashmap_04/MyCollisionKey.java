package main.java.org.mzerek.solutions.hashmap_04;

import java.util.Objects;

public class MyCollisionKey {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCollisionKey that = (MyCollisionKey) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public MyCollisionKey(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
