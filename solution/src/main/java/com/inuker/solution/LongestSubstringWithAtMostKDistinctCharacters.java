package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dingjikerbo on 16/11/27.
 */

public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * 思路跟Longest Substring With At Most Two Distinct Characters一样，只是给2改成k，要注意k等于0时返回0
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() > k) {
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

    // 两个指针，i尽量往后走，当发现不同的字符数key超过k时从j开始收缩，一直到key减少到k为止
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int len = s.length(), key = 0, max = 0;

        for (int i = 0, j = 0; i < len; i++) {
            if (counts[s.charAt(i)]++ == 0) {
                key++;
            }

            for ( ; j < i && key > k; ) {
                if (--counts[s.charAt(j++)] == 0) {
                    key--;
                }
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
