package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/27.
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    // eceba
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int len = s.length(), key = 0, max = 0;

        for (int i = 0, j = 0; i < len; i++) {
            if (counts[s.charAt(i)]++ == 0) {
                key++;
            }

            for ( ; j < i && key > 2; ) {
                if (--counts[s.charAt(j++)] == 0) {
                    key--;
                }
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
