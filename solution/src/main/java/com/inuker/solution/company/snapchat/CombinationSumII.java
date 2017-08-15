package com.inuker.solution.snapchat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/15.
 */

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        helper(candidates, result, new LinkedList<>(), target, 0);
        return result;
    }

    private void helper(int[] candidates, List<List<Integer>> result, List<Integer> list, int target, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        } else if (index >= candidates.length) {
            return;
        }

        list.add(candidates[index]);
        helper(candidates, result, list, target - candidates[index], index + 1);
        list.remove(list.size() - 1);

        for ( ; index < candidates.length - 1 && candidates[index + 1] == candidates[index]; index++);

        helper(candidates, result, list, target, index + 1);
    }
}
