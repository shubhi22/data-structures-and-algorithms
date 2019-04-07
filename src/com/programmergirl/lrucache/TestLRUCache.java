package com.programmergirl.lrucache;

public class TestLRUCache {

    public static void main(String args[]) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D");
        cache.put(5, "E");
        System.out.println(cache);
        cache.put(6, "F");
        cache.put(7, "G");
        cache.put(8, "H");
        System.out.println(cache);
        System.out.println(cache.get(6));
        System.out.println(cache.get(4));
        System.out.println(cache);

        cache.put(9, "G");
        System.out.println(cache);

    }

}
