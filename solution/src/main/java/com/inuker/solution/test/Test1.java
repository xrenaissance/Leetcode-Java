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

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                f[i + 1] = f[i - 1];
            }
            if (s.charAt(i) != '0') {
                f[i + 1] += f[i];
            }
        }
        return f[n];
    }

}
