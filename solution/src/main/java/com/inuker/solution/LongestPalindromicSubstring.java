package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class LongestPalindromicSubstring {

    // 耗时78ms，彻底的O(n^2)
    public String longestPalindrome(String s) {
        int len = s.length();

        if (len == 0) {
            return "";
        }

        boolean[][] f = new boolean[len][len];

        f[0][0] = true;

        int maxLen = 1, begin = 0;

        char[] ss = s.toCharArray();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 这里注意不能掉了j >= i - 2
                if ((j >= i - 2 || f[j + 1][i - 1]) && ss[j] == ss[i]) {
                    f[j][i] = true;

                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        begin = j;
                    }
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private int begin, maxLen;

    // 耗时14ms，最坏情况O(n^2)，平均情况O(n*len)
    public String longestPalindrome2(String s) {
        int len = s.length();

        if (len == 0) {
            return "";
        }

        char[] ss = s.toCharArray();
        for (int i = 0; i < len; i++) {
            findLongestPalindrome(ss, i, i);
            findLongestPalindrome(ss, i, i + 1);
        }

        return s.substring(begin, begin + maxLen);
    }

    private void findLongestPalindrome(char[] s, int j, int k) {
        for ( ; j >= 0 && k < s.length && s[j] == s[k]; j--, k++);
        if (k - j - 1 > maxLen) {
            maxLen = k - j - 1;
            begin = j + 1;
        }
    }
}
