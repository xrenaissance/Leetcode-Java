package com.example;

import com.leetcode.google.DecodeString;
import com.leetcode.google.MissingRanges;
import com.leetcode.google.SentenceScreenFitting;
import com.leetcode.google.ShortestDistanceFromAllBuildings;
import com.leetcode.google.WordSquares;
import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int dis = new ShortestDistanceFromAllBuildings().shortestDistance(new int[][] {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
        });
        System.out.println(dis);
    }
}

