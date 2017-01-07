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
