package amazon.medium.lc146_lru_cache;

import java.util.Map;
import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    Map<Integer, Node> store = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head; 
    }

    public void addNode(Node newNode) {
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    public void deleteNode(Node delNode) {
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(store.containsKey(key)) {
            Node curr = store.get(key);
            int val = curr.val;

            deleteNode(curr);
            store.remove(key);
            addNode(curr);
            store.put(key, head.next);

            return val;

        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(store.containsKey(key)) {
            Node node = store.get(key);
            store.remove(key);
            deleteNode(node);
        }

        if(store.size() == capacity) {
            store.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        store.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */