package com.example;

import com.inuker.solution.FactorCombinations;
import com.inuker.solution.RestoreIPAddresses;
import com.leetcode.google.DecodeString;
import com.leetcode.google.GenerateParentheses;
import com.leetcode.google.MissingRanges;
import com.leetcode.google.QueueReconstructionByHeight;
import com.leetcode.google.SentenceScreenFitting;
import com.leetcode.google.ShortestDistanceFromAllBuildings;
import com.leetcode.google.StrobogrammaticNumberII;
import com.leetcode.google.UTFValidation;
import com.leetcode.google.WordBreakII;
import com.leetcode.google.WordSquares;
import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> lists = new FactorCombinations().getFactors(128);
//        List<List<Integer>> lists = new FactorCombinations().getFactors(23848713);
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

