package com.inuker.solution;

public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }



}
