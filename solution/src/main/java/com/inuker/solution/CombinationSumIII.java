package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(k, n, 1, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int k, int n, int start, List<List<Integer>> result, List<Integer> path) {
        if (k == 0 && n == 0) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        if (n < 0 || k < 0 || start > 9) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k - 1, n - i, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
