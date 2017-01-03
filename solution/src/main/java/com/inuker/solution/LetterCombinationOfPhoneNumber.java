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
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }
        helper(digits, 0, "", result);
        return result;
    }

    private void helper(String s, int start, String t, List<String> result) {
        if (start == s.length()) {
            result.add(t);
            return;
        }
        int n = s.charAt(start) - '0';
        for (char c : ARR[n].toCharArray()) {
            helper(s, start + 1, t + c, result);
        }
    }
}
