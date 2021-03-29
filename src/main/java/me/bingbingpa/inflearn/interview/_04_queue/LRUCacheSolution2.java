package me.bingbingpa.inflearn.interview._04_queue;

import java.util.HashMap;

public class LRUCacheSolution2 {
    private int cacheSize;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCacheSolution2(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCacheSolution2 lruCache = new LRUCacheSolution2(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);
        lruCache.print();
    }

    private void query(int number) {
        // containsKey 의 시간복잡도는 O(1)
        if (map.containsKey(number)) {
            Node node = map.get(number);
            remove(node);
            addToHead(node);
        } else {
            Node nodeToAdd = new Node();
            nodeToAdd.value = number;
            if (map.size() == this.cacheSize) {
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd);
            map.put(number, nodeToAdd);
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
    }

}
