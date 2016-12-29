package com.inuker.solution.test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 2016/12/29.
 */

public class Test1 {

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<String>();
        if (digits.length() == 0) {
            return list;
        }
        helper(digits, 0, list, new StringBuilder());
        return list;
    }

    private void helper(String digit, int start, List<String> path, StringBuilder sb) {
        if (start == digit.length()) {
            path.add(sb.toString());
            return;
        }

        int n = digit.charAt(start) - '0';
        for (char c : ARR[n].toCharArray()) {
            sb.append(c);
            helper(digit, start + 1, path, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
