package com.kunal.Dsa.StacksandQueues;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
       Node next,prev;
       int val,key;
       Node(int k,int v){
           this.key=k;
           this.val=v;
       }
    }

        static int capacity;
        static Node tail,head;
        static Map<Integer,Node> map;

    LRUCache(int capacity){
      this.capacity = capacity;
      this.map = new HashMap<>();
      this.tail = new Node(0,0);
      this.head = new Node(0,0);
      head.next=tail;
      tail.prev=head;
    }

    private void remove(Node node) {
       node.prev.next=node.next;
       node.next.prev=node.prev;
    }

    private void insertToFront(Node node) {
       node.next = head.next;
       node.prev=head;
       head.next.prev = node;
       head.next=node;
    }

    public int get(int key) {
       if(map.containsKey(key)){
           Node node = map.get(key);
           remove(node);
           insertToFront(node);
           return node.val;
       }
       return -1;
    }

    public void put(int key, int value) {
       if(map.containsKey(key)){
           remove(map.get(key));
       }

       Node newNode = new Node(key,value);
       insertToFront(newNode);
       map.put(key,newNode);

       if(map.size()>capacity){
           Node lru = tail.prev;
           remove(lru);
           map.remove(lru.key);
       }
    }
        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);

            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // returns 1
            cache.put(3, 3);                  // evicts key 2
            System.out.println(cache.get(2)); // returns -1
            cache.put(4, 4);                  // evicts key 1
            System.out.println(cache.get(1)); // returns -1
            System.out.println(cache.get(3)); // returns 3
            System.out.println(cache.get(4)); // returns 4
    }
}
