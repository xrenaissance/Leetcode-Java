package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/21.
 */

public class MinimumWindowSubstring {

    // 耗时8ms，时间复杂度O(n)
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int CHAR_MAX = 256;
        int[] cns = new int[CHAR_MAX];
        int[] cnt = new int[CHAR_MAX];

        for (char c : tt) {
            cnt[c]++;
        }

        // 这个k相当重要，好好体会一下为什么
        int start = 0, k = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < ss.length; j++) {
            char c = ss[j];

            if (cnt[c] <= 0) {
                continue;
            }

            if (++cns[c] <= cnt[c]) {
                k++;
            }

            if (k >= tt.length) {
                for ( ; i <= j; i++) {
                    c = ss[i];

                    if (cnt[c] <= 0) {
                        continue;
                    }

                    if (cns[c] > cnt[c]) {
                        cns[c]--;
                    } else {
                        break;
                    }
                }

                if (j - i + 1 <= minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
