package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeLinkNode;
import com.inuker.solution.TreeNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int f[][] = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]) + 1;
                }
            }
        }
        return f[n1][n2];
    }

    public boolean isOneEditDistance(String s, String t) {
        int sn = s.length(), tn = t.length();
        if (sn > tn) {
            return isOneEditDistance(t, s);
        }
        if (tn - sn > 1) {
            return false;
        }
        if (s.equals(t)) {
            return false;
        }
        for (int i = 0; i < sn; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sn == tn) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return true;
    }

}
