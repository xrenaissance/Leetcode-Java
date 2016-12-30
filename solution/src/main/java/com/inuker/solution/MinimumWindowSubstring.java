package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/21.
 */

public class MinimumWindowSubstring {

    // 耗时8ms，时间复杂度O(n)
    public String minWindow(String s, String t) {
        int[] cns = new int[256];
        int[] cnt = new int[256];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int count = 0, minLen = 0, minStart = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (++cns[c] <= cnt[c]) {
                ++count;
            }

            if (count >= t.length()) {
                for ( ; j < i; j++) {
                    char cc = s.charAt(j);
                    if (cnt[cc] == 0) {
                        continue;
                    }
                    if (cns[cc] > cnt[cc]) {
                        cns[cc]--;
                    } else {
                        break;
                    }
                }
                int len = i - j + 1;
                if (minLen == 0 || len < minLen) {
                    minLen = len;
                    minStart = j;
                }
            }
        }
        return minLen > 0 ? s.substring(minStart, minStart + minLen) : "";
    }
}
