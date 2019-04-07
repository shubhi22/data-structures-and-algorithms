package com.programmergirl.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    
    private LinkedList<K> cachedKeys;
    private Map<K, V> cacheMap;
    private static final int LRU_CACHE_SIZE = 5;
    
    LRUCache() {
        this.cachedKeys = new LinkedList<>();
        this.cacheMap = new HashMap<>();
    }
    
    public void put(K key, V value) {
        if(cachedKeys.contains(key)) {
            //only update the contents and move it to front
            cacheMap.put(key, value);
            cachedKeys.remove(key);
            cachedKeys.addFirst(key);
        }
        else {
            if(isFull()) {
                //remove last node
                K removedKey = cachedKeys.removeLast();
                cacheMap.remove(removedKey);
            }
            cachedKeys.addFirst(key);
            cacheMap.put(key, value);
        }
    }
    
    public V get(K key) {
        V value = null;
        if(cachedKeys.contains(key)) {
            value = cacheMap.get(key);
            //move it to front
            cachedKeys.remove(key);
            cachedKeys.addFirst(key);
        }
        return value;
    }
    
    public boolean isFull() {
        return cachedKeys.size() == LRU_CACHE_SIZE;
    }
    
    public String toString() {
        return cachedKeys.toString();
    }
}