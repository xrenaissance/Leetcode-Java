package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class CombinationSum {

    // 这题关键在于去重，这里没必要排序
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            /**
             * 注意这里下一个start取i，表示当前数仍可以重复取
             */
            dfs(candidates, target - candidates[i], i, result, list);
            list.remove(list.size() - 1);
        }
    }
}
