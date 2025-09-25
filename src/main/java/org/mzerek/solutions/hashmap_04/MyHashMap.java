package main.java.org.mzerek.solutions.hashmap_04;

public class MyHashMap<K, V> {
    private final static int DEFAULT_CAPACITY = 16;

    private int capacity;

    private int size;

    private Node<K, V>[] table;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[DEFAULT_CAPACITY];
    }

    private static class Node<K, V> {
        K key;
        V value;

        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);

        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        if (size > capacity) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K, V> previous = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if(previous == null) {
                    table[index] = node.next;
                } else {
                    previous.next = node.next;
                }
                size--;
                return;
            }
            previous = node;
            node = node.next;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                Node<K, V> next = node.next;
                int index = hash(node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }
}