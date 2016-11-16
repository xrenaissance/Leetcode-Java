package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 29999; i++) {
            sb.append("a");
        }
        String s = sb.toString();

        long start = System.currentTimeMillis();
        new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(System.currentTimeMillis() - start);

         start = System.currentTimeMillis();
        new LongestPalindromicSubstring().longestPalindrome2(s);
        System.out.println(System.currentTimeMillis() - start);
    }
}
