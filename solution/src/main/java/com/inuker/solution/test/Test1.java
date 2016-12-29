package com.inuker.solution.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<String>();
        helper(list, "", n, 0);
        return list;
    }

    private void helper(List<String> result, String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) {
            helper(result, s + "(", left - 1, right + 1);
        }

        if (right > 0) {
            helper(result, s + ")", left, right - 1);
        }
    }

}
