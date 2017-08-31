package com.example;

import com.leetcode.google.DecodeString;
import com.leetcode.google.MissingRanges;
import com.leetcode.google.SentenceScreenFitting;
import com.leetcode.google.ShortestDistanceFromAllBuildings;
import com.leetcode.google.StrobogrammaticNumberII;
import com.leetcode.google.UTFValidation;
import com.leetcode.google.WordSquares;
import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new StrobogrammaticNumberII().findStrobogrammatic(4);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}

