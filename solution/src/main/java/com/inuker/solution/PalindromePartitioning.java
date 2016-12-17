package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwentian on 2016/12/17.
 */

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                // 此处i - left <= 2 或 1皆可
                if (s.charAt(left) == s.charAt(i) && (i-left <= 2 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);

                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
