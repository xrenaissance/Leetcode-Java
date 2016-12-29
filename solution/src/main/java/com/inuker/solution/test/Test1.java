package com.inuker.solution.test;

import com.inuker.solution.PalindromeLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {


    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n + 1];
        cuts[0] = -1;
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int cut = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j > i - 2 || f[j + 1][i - 1])) {
                    f[j][i] = true;
                    cut = Math.min(cut, cuts[j] + 1);
                }
            }
            cuts[i + 1] = cut;
        }
        return cuts[n];
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[] f = new LinkedList[n + 1];
        f[0] = new LinkedList<List<String>>();
        f[0].add(Collections.EMPTY_LIST);

        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            f[i + 1] = new LinkedList<List<String>>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j > i - 2 || flag[j + 1][i - 1])) {
                    flag[j][i] = true;
                    for (List<String> list : f[j]) {
                        List<String> list2 = new LinkedList<String>(list);
                        list2.add(s.substring(j, i + 1));
                        f[i + 1].add(list2);
                    }
                }
            }
        }

        return f[n];
    }
}
