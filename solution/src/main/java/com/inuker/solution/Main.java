package com.inuker.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(new WordLadder().ladderLength2("hit", "cog", set));
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 29999; i++) {
//            sb.append("a");
//        }
//        String s = sb.toString();
//
//        long start = System.currentTimeMillis();
//        new LongestPalindromicSubstring().longestPalindrome(s);
//        System.out.println(System.currentTimeMillis() - start);
//
//         start = System.currentTimeMillis();
//        new LongestPalindromicSubstring().longestPalindrome2(s);
//        System.out.println(System.currentTimeMillis() - start);
    }
}
