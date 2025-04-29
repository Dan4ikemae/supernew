import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            String name = "User" + rand.nextInt(100000);
            table.put(new MyTestingClass(id, name), i);
        }

        for (int i = 0; i < 11; i++) {
            int count = 0;
            var node = table.getChain(i);
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        BST<Integer, String> tree = new BST<>();
        tree.insert(20, "twenty");
        tree.insert(10, "ten");
        tree.insert(30, "thirty");

        for (BST<Integer, String> node : tree) {
            System.out.println("key is " + node.key + ", value is " + node.value);
        }
    }
}