package com.inuker.solution.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE, sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                for ( ; j <= i; j++) {
                    if (sum - nums[j] < s) {
                        break;
                    }
                    sum -= nums[j];
                }
                len = Math.min(len, i - j + 1);
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public String minWindow(String s, String t) {
        int[] fs = new int[256], ft = new int[256];
        for (char c : t.toCharArray()) {
            ft[c]++;
        }
        int count = 0, minLen = Integer.MAX_VALUE, idx = -1;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (++fs[s.charAt(i)] <= ft[s.charAt(i)]) {
                ++count;
            }
            if (count >= t.length()) {
                for ( ; j < i; j++) {
                    char c = s.charAt(j);
                    if (fs[c] > ft[c]) {
                        fs[c]--;
                    } else {
                        break;
                    }
                }
                if (i - j + 1 < minLen) {
                    minLen = i - j + 1;
                    idx = j;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(idx, idx + minLen);
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
