package com.leetcode.topics.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/15.
 */

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        helper(k, n, result, new LinkedList<Integer>(), 1);
        return result;
    }

    private void helper(int k, int n, List<List<Integer>> result, List<Integer> list, int cur) {
        if (n == 0 && k == 0) {
            result.add(new LinkedList<>(list));
            return;
        }

        if (cur > 9) {
            return;
        }

        list.add(cur);
        helper(k - 1, n - cur, result, list, cur + 1);
        list.remove(list.size() - 1);

        helper(k, n, result, list, cur + 1);
    }
}
