package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/21.
 */

public class MinimumWindowSubstring {

    // 耗时8ms，时间复杂度O(n)
    public String minWindow(String s, String t) {
        int CHAR_MAX = 256;
        int[] ss = new int[CHAR_MAX];
        int[] tt = new int[CHAR_MAX];
        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i)]++;
        }
        int count = 0, min = Integer.MAX_VALUE, start = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (++ss[s.charAt(j)] <= tt[s.charAt(j)]) {
                ++count;
            }
            if (count >= t.length()) {
                for ( ; i < j; i++) {
                    char c = s.charAt(i);
                    if (tt[c] > 0 && ss[c] <= tt[c]) {
                        break;
                    }
                    ss[c]--;
                }
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
