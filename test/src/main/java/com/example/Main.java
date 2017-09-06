package com.example;

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
        List<String> list = generatePalindromes("a");
        for (String s : list) {
            System.out.println("(" + s+")");
        }
    }

    public static List<String> generatePalindromes(String s) {
        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char single = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 != 0) {
                if (single != 0) {
                    return list;
                }
                single = (char) i;
                counts[i] = ((counts[i] >> 1) << 1);
            }
            for (int j = 0; j < counts[i]; j += 2) {
                sb.append((char)i);
            }
        }

        helper(sb, "" + (single != 0 ? single : ""), list);
        return list;
    }

    private static void helper(StringBuilder sb, String cur, List<String> list) {
        if (sb.length() == 0) {
            list.add(cur);
            return;
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
                continue;
            }
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            helper(sb, c + cur + c, list);
            sb.insert(i, c);
        }
    }
}

