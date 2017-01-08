package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/27.
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /**
     * 下面两种写法思路都一样，只是一个用map，一个用数组
     */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() > 2) {
                for ( ; j < i; ) {
                    char c1 = s.charAt(j++);
                    map.put(c1, map.get(c1) - 1);
                    if (map.get(c1) == 0) {
                        map.remove(c1);
                        break;
                    }
                }
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    // eceba
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
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
