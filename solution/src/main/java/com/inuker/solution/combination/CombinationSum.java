package com.inuker.solution.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/15.
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
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
        helper(candidates, result, list, target - candidates[index], index);
        list.remove(list.size() - 1);

        helper(candidates, result, list, target, index + 1);
    }
}
