package me.bingbingpa.inflearn.interview._04_queue;

import java.util.Deque;
import java.util.LinkedList;

public class LRUCacheSolution1 {
    private int cacheSize;
    private Deque<Integer> cache;

    public LRUCacheSolution1(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new LinkedList<>();
    }

    public static void main(String[] args) {
        LRUCacheSolution1 lruCache = new LRUCacheSolution1(3);
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
        // contains 의 시간 복잡도는 O(n)
        if (!cache.contains(number)) {
            if (cache.size() == this.cacheSize) {
                cache.removeLast();
            }

            cache.addFirst(number);
        } else {
            cache.remove(number);
            cache.addFirst(number);
        }
    }

    private void print() {
        System.out.println(cache);
    }
}
