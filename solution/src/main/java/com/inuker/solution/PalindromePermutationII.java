package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/19.
 */

public class PalindromePermutationII {
    /**
     * 这题就是生成一半的所有排列，然后镜像
     */
    public List<String> generatePalindromes(String s) {
        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder single = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for ( ; count > 1; sb.append((char) i), count -= 2);
            if (count == 1) {
                single.append((char) i);
            }
        }
        List<String> result = new LinkedList<String>();
        helper(sb.toString(), single.toString(), result);
        return result;
    }

    private void helper(String s, String t, List<String> list) {

    }
}
