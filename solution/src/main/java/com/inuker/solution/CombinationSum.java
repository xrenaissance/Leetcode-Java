package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class CombinationSum {

    // 这题关键在于去重
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], result, path);
            path.remove(path.size() - 1);
        }
    }
}
