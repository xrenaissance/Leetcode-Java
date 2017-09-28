package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        boolean result = canArrangeWords(new String[] {
                "abc", "ce", "ef", "fu", "cd", "dx", "xc"
        });
        System.out.print(result);
    }

    public static int perfectNumberCheck(int n) {
        int k = n;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                k -= i;
            }
        }
        return k == 0 ? 1 : 0;
    }

    public static boolean canArrangeWords(String[] words) {
        List<String> set = new ArrayList<String>();
        if (helper(null, words, set)) {
            for (String s : set) {
                System.out.print(s + "->");
            }
            return true;
        }
        return false;
    }

    public static boolean helper(String word, String[] words, List<String> set) {
        if (set.size() == words.length) {
            return true;
        }

        for (String s : words) {
            if (!set.contains(s) && (word == null || s.charAt(0) == word.charAt(word.length() - 1))) {
                set.add(s);
                if (helper(s, words, set)) {
                    return true;
                }
                set.remove(s);
            }
        }
        return false;
    }
}

