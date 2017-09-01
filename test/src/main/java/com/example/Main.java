package com.example;

import com.leetcode.google.DecodeString;
import com.leetcode.google.MissingRanges;
import com.leetcode.google.QueueReconstructionByHeight;
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
        int[][] result = new QueueReconstructionByHeight().reconstructQueue(new int[][] {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });
        for (int[] res : result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}

