package com.programmergirl.hashtable;

public class TestSimpleHashtable {

    public static void main(String args[]) {
        SimpleHashtable<Integer, String> ht = new SimpleHashtable<>();
        ht.put(1, "A");
        ht.put(2, "B");
        ht.put(3, "M");

        System.out.println(ht);

        System.out.println(ht.get(3));

    }


}
