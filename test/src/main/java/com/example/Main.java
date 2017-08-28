package com.example;

import com.leetcode.google.SentenceScreenFitting;
import com.leetcode.google.WordSquares;
import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<String>> result = new WordSquares().wordSquares(new String[] {
                "area", "lead", "wall", "lady", "ball"
        });
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s  + " ");
            }
            System.out.println();
        }

    }
}

