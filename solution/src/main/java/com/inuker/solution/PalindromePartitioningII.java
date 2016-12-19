package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class PalindromePartitioningII {

    public int minCut(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        boolean[][] flags = new boolean[len][len];
        int[] cuts = new int[len];

        for (int i = 0; i < len; i++) {
            cuts[i] = i;
        }

        for (int end = 0; end < len; end++) {
            for (int start = end; start >= 0; start--) {
                if (s.charAt(start) == s.charAt(end) && (end - start < 2 || flags[start + 1][end - 1])) {
                    flags[start][end] = true;

                    // 这里非常容易出错，cuts[-1]=-1
                    int prevCuts = start > 0 ? cuts[start - 1] : -1;
                    cuts[end] = Math.min(cuts[end], prevCuts + 1);
                }
            }
        }

        return cuts[len - 1];
    }

    /**
    public int minCut(String s) {
        int len = s.length();

        boolean[][] f = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if ((s.charAt(i) == s.charAt(j)) && (i - j < 2 || f[j + 1][i - 1])) {
                    f[j][i] = true;
                }
            }
        }

        int[] cuts = new int[len];

        for (int i = 0; i < len; i++) {
            cuts[i] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[j][i]) {
                    int lastCuts = j == 0 ? -1 : cuts[j - 1];
                    cuts[i] = Math.min(cuts[i], lastCuts + 1);
                }
            }
        }

        return cuts[len - 1];
    }
     */
}
