package com.inuker.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] arr = {
                6, 3, 8, 2, 5, 7, 9
        };

        int k = new KthLargestElementInArray().findKthLargest4(arr, 2);

        System.out.println(k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

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
