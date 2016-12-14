package com.inuker.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class LetterCombinationOfPhoneNumber {

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // 耗时3ms
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if (digits.length() == 0) {
            return result;
        }
        helper(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(String digits, int k, StringBuilder sb, List<String> result) {
        if (k == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int n = digits.charAt(k) - '0';
        for (int i = 0; i < ARR[n].length(); i++) {
            sb.append(ARR[n].charAt(i));
            helper(digits, k + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
