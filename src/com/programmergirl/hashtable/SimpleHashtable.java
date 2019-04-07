package com.programmergirl.hashtable;

import java.util.LinkedList;
import java.util.List;

public class SimpleHashtable<K, V> {
    
    private LinkedList<Entry<K,V>>[] hashtable;
    private int size;
    
    SimpleHashtable() {
        hashtable = new LinkedList[2];
        for(int i=0; i < 2; i++) {
            hashtable[i] = new LinkedList<>();
        }
        this.size = 0;
    }
    
    public void put(K key, V value)  {
        int hashedKey = hashKey(key);
        List<Entry<K, V>> list = hashtable[hashedKey];
        list.add(new Entry<>(key, value));
    }
    
    //returns null if not found
    public V get(K key) {
        int hashedKey = hashKey(key);
        List<Entry<K, V>> list = hashtable[hashedKey];
        for(Entry<K, V> entry : list) {
            if(entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    private int hashKey(K key) {
        return Math.abs(key.hashCode()) % hashtable.length;
    }
    
    private class Entry<K, V> {
        K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public String toString() {
            return "[key=" + key + ", value=" + value + "]";
        }
    }
    
    public String toString() {
        String result = "";
        
        for(int i=0; i<2; i++) {
            result += hashtable[i].toString();
            result += "\n";
        }
        
        return result + "-----\n";
    }
}

