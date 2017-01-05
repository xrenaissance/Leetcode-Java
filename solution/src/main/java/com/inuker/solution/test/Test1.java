package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.PathSum;
import com.inuker.solution.TreeLinkNode;
import com.inuker.solution.TreeNode;
import com.inuker.solution.UndirectedGraphNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        if (k <= 0 || n <= 0) {
            return result;
        }
        dfs(n, k, 1, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int target, int k, int start, List<List<Integer>> result, List<Integer> list) {
        if (target == 0 && k == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (target <= 0 || k <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(target - i, k - 1, i, result, list);
            list.remove(list.size() - 1);
        }
    }

     boolean knows(int a, int b) {
        return false;
     }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

     int read4(char[] buf) {
         return 0;
     }

    private static final String[] LESS20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] LESS100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] THOUSAND = {
            "", "Thousand", "Million", "Billion"
    };

}
