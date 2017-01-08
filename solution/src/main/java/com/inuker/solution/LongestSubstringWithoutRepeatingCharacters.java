package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // "abcabcbb"
    // tmmzuxt
    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[256];
        int len = s.length(), longest = 0;

        for (int i = 0, j = 0; i < len; i++) {
            if (++counts[s.charAt(i)] > 1) {
                for ( ; j < i; ) {
                    /**
                     * 这里容易出错，这里要马上j++，不能放在for里j++，因为可能下面会提前break了
                     */
                    char c = s.charAt(j++);
                    counts[c]--;
                    if (c == s.charAt(i)) {
                        break;
                    }
                }
            }

            longest = Math.max(longest, i - j + 1);
        }

        return longest;
    }
}
