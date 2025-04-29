import java.util.*;

public class MyHashTable<K, V> {
    public class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private int capacity = 11;
    private int size = 0;

    public MyHashTable() {
        table = new Node[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public V get(K key) {
        Node<K, V> current = table[hash(key)];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public Node<K, V> getChain(int index) {
        return table[index];
    }

    public int size() {
        return size;
    }
}
