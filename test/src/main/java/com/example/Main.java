package com.example;

import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        ZigzagIterator itor = new ZigzagIterator(list1, list2);
        while (itor.hasNext()) {
            System.out.print(itor.next() + " ");
        }
    }
}
