package me.bingbingpa.inflearn.interview._04_queue;

import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCacheSolution3 {
    private int cacheSize;
    private Set<Integer> cache;

    public LRUCacheSolution3(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new LinkedHashSet<>();
    }

    public static void main(String[] args) {
        LRUCacheSolution3 lruCache = new LRUCacheSolution3(3);
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
        if (!cache.contains(number)) {
            if (cache.size() == cacheSize) {
                Integer firstOne = cache.iterator().next();
                cache.remove(firstOne);
            }

            cache.add(number);
        } else {
            cache.remove(number);
            cache.add(number);
        }
    }

    private void print() {
        System.out.println(cache);
    }
}
