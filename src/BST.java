import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>> {
    K key;
    V value;
    BST<K, V> left, right;
    int size = 0;

    public void insert(K key, V value) {
        if (this.key == null) {
            this.key = key;
            this.value = value;
            size++;
            return;
        }

        int cmp = key.compareTo(this.key);
        if (cmp < 0) {
            if (left == null) left = new BST<>();
            left.insert(key, value);
        } else if (cmp > 0) {
            if (right == null) right = new BST<>();
            right.insert(key, value);
        } else {
            this.value = value;
        }
    }

    public V find(K key) {
        if (this.key == null) return null;

        int cmp = key.compareTo(this.key);
        if (cmp == 0) return value;
        if (cmp < 0 && left != null) return left.find(key);
        if (cmp > 0 && right != null) return right.find(key);
        return null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<BST<K, V>> iterator() {
        List<BST<K, V>> nodes = new ArrayList<>();
        Stack<BST<K, V>> stack = new Stack<>();
        BST<K, V> curr = this;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodes.add(curr);
            curr = curr.right;
        }
        return nodes.iterator();
    }
}