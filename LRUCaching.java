import java.util.HashMap;

public class LRUCaching {
    // int capacity;
    public static class Node {
        int k;
        int v;
        Node next;
        Node prev;

        public Node(int v, int k) {
            this.v = v;
            this.k = k;
            this.next = this.prev = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;

    LRUCaching(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            // removing the node:
            remove(map.get(k));
        } else if (map.size() == capacity) {
            // remove list recently used data
            remove(tail);

        } else {
            Node newnode = new Node(v, k);
            insert(newnode);
        }
    }

    public int get(int k) {
        Node node = map.get(k);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.v;
    }

    Node head = null;
    Node tail = null;

    void insert(Node newnode) {
        map.put(newnode.k, newnode);
        if (head == null || tail == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    void remove(Node node) {
        map.remove(node.k);
        if (node == head) {
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;

        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
            node.prev = null;

        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }
    }

}
