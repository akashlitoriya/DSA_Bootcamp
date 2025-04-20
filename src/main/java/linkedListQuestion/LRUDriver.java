package linkedListQuestion;

import java.util.HashMap;
class LRUCache {
    int size = 0;
    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        map = new HashMap<Integer, Node>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        //remove it for its position
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //add it at front of the cache
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        return node.val;
    }

    public void put(int key, int value) {
        if(size < cap){
            if(!map.containsKey(key)){
                size++;
                Node newNode = new Node(key,value);
                newNode.next = head.next;
                head.next.prev = newNode;
                head.next = newNode;
                newNode.prev = head;
                map.put(key, newNode);
            }else{
                Node node = map.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;

                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;
                node.val = value;
                map.put(key, node);
            }
        }else{
            //check if key is already present in cache or not
            if(map.containsKey(key)){
                Node node = map.get(key);
                //remove it from prev position
                node.prev.next = node.next;
                node.next.prev = node.prev;

                //insert it in the front of cache
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;
                node.val = value;
                map.put(key, node);
            }else{
                //remove the LRU node
                Node node = tail.prev;
                node.prev.next = tail;
                tail.prev = node.prev;

                map.remove(node.key);

                Node newNode = new Node(key, value);
                newNode.next = head.next;
                newNode.next.prev = newNode;
                head.next = newNode;
                newNode.prev = head;

                map.put(key, newNode);
            }
        }
    }
}
class Node{
    int val;
    int key;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


public class LRUDriver {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
    }
}

