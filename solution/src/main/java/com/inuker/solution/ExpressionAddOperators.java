package com.inuker.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/21.
 */

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> rst = new LinkedList<String>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long last) {
        if (pos == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                // 从pos=0开始的，所以不参与运算，只是组成第一个数
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - last + last * cur, last * cur);
            }
        }
    }
}
