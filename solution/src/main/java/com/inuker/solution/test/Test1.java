package com.inuker.solution.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[256];
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (++counts[s.charAt(i)] > 1) {
                for ( ; j < i; ) {
                    char c = s.charAt(j++);
                    counts[c]--;
                    if (c == s.charAt(i)) {
                        break;
                    }
                }
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i > 0 ? nums[i - 1] : 0;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        map.put(0, -1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i] - k);
            if (j != null && j < i) {
                max = Math.max(max, i - j);
            }
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }

    boolean knows(int a, int b) {
        return false;
    }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    int read4(char[] buf) {
        return 0;
    }

    private static final String[] LESS20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] LESS100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] THOUSAND = {
            "", "Thousand", "Million", "Billion"
    };

}
