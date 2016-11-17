package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    // 耗时43ms
    public int lengthOfLongestSubstring(String s) {
        int CHAR_MAX = 256;
        int[] counts = new int[CHAR_MAX];
        char[] ss = s.toCharArray();

        int longest = 0;
        for (int i = 0, j = 0; i < ss.length; i++) {
            if (++counts[ss[i]] <= 1) {
                longest = Math.max(longest, i - j + 1);
            } else {
                for ( ; j <= i; ) {
                    --counts[ss[j++]];
                    if (counts[ss[i]] <= 1) {
                        break;
                    }
                }
            }
        }
        return longest;
    }
}
