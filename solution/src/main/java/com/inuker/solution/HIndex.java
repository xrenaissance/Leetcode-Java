package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/23.
 */
/**
 * https://leetcode.com/articles/h-index/
 */

/**
 * TestCase
 * [0]
 * [1]
 * []
 * [100]
 */
public class HIndex {

    // 耗时4ms，时间复杂度O(nlgn)，因为这里有排序
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int citation = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int min = Math.min(citations.length - i, citations[i]);
            citation = Math.max(min, citation);
        }

        return citation;
    }

    // 耗时1ms，时间复杂度O(n)
    public int hIndex2(int[] citations) {
        int len = citations.length;

        int[] f = new int[len + 1];
        for (int n : citations) {
            if (n >= len) {
                f[len]++;
            } else {
                f[n]++;
            }
        }

        for (int i = len, j = 0; i >= 0; i--) {
            j += f[i];
            if (j >= i) {
                return i;
            }
        }

        return 0;
    }
}
