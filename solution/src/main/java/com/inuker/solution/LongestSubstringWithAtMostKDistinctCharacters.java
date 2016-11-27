package com.inuker.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dingjikerbo on 16/11/27.
 */

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int CHAR_MAX = 256;
        int[] counts = new int[CHAR_MAX];
        Set<Character> set = new HashSet<Character>();
        int longest = 0;
        int i = 0, j = 0;
        for ( ; j < s.length(); j++) {
            counts[s.charAt(j)]++;
            set.add(s.charAt(j));
            if (set.size() > k) {
                longest = Math.max(longest, j - i);
                for ( ; i < j; i++) {
                    if (--counts[s.charAt(i)] == 0) {
                        set.remove(s.charAt(i));
                        i++;
                        break;
                    }
                }
            }
        }
        return Math.max(longest, j - i);
    }
}
