package leetcode.topinterview150;

import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.

int get(int key) Return the value of the key if the key exists, otherwise return -1.

void put(int key, int value) Update the value of the key if the key exists.

Otherwise, add the key-value pair to the cache.

If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

    Map<Integer, Node> map;
    Node start;
    Node end;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        start = new Node(0, 0);
        end = new Node(0, 0);
        this.capacity = capacity;
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeNode(temp);
        } else {
            if (capacity == map.size()) {
                Node temp = end.prev;
                removeNode(temp);
                map.remove(temp.key);
            }
        }
        addNode(node);
        map.put(key, node);

    }

    private void removeNode(Node node) {
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }

    private void addNode(Node node) {
        node.next = start.next;
        start.next = node;
        node.prev = start;
        node.next.prev = node;
    }

    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}


