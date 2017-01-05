package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class CombinationSumIII {

    /**
     * 这题的意思是不允许重复数字
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
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
            /**
             * 如果这题允许重复数字则这取i，否则取i+1。
             */
            dfs(target - i, k - 1, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
