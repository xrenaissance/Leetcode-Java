package com.example;

import com.leetcode.google.MissingRanges;
import com.leetcode.google.SentenceScreenFitting;
import com.leetcode.google.WordSquares;
import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new MissingRanges().findMissingRanges(new int[] {
                Integer.MIN_VALUE, Integer.MAX_VALUE
        }, Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

