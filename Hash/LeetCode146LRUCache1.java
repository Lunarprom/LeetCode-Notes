package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Regular solution by leveraging doubly linked list.
 * Also each node needs to store the key and value used to query the node from the map.
 */
public class LeetCode146LRUCache1 {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LeetCode146LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            // Remove the node from current list
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            // Put the node to head
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;
            lru.prev.next = tail;
            tail.prev = lru.prev;

            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        moveToHead(node);
        map.put(key, node);
    }

    private void moveToHead(Node node) {
        // Move the node to head;
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */