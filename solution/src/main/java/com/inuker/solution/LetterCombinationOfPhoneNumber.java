package com.inuker.solution;

import java.util.ArrayList;
import java.util.Collections;
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
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<String>();
        helper(digits, 0, result, new StringBuilder());
        return result;
    }

    private void helper(String digits, int start, List<String> list, StringBuilder sb) {
        if (start >= digits.length()) {
            list.add(sb.toString());
            return;
        }

        String s = ARR[digits.charAt(start) - '0'];

        // 这里要注意单独拿出来处理
        if (s.length() == 0) {
            helper(digits, start + 1, list, sb);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            int len = sb.length();
            sb.append(s.charAt(i));
            helper(digits, start + 1, list, sb);
            sb.setLength(len);
        }
    }
}
