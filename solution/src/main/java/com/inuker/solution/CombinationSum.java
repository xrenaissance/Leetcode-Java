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
        /**
         * 排序是必要的
         */
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> list) {
        /**
         * target小于0退出的条件千万别掉了,题目给的条件是所有数都为正的
         */
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            /**
             * 这一条千万别掉了，因为如果当前数和上一个数相等，则是上一个数下的子集，不能再重复计算了
             */
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
