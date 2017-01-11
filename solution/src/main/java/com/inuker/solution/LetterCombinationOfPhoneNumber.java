package com.inuker.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class LetterCombinationOfPhoneNumber {

    /**
     * leetcode的测试用例中不包括包含"0"或"1"的情况
     */

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

    /**
     * 非递归法，BFS,耗时5ms
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if (digits.length() == 0) {
            return queue;
        }

        Queue<String> next = new LinkedList<>();
        queue.add("");

        for (int i = 0; i < digits.length() && !queue.isEmpty(); ) {
            String s = queue.poll();
            int n = digits.charAt(i) - '0';
            for (char c : ARR[n].toCharArray()) {
                next.add(s + c);
            }
            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                i++;
            }
        }
        return queue;
    }
}
