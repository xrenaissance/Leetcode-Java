package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int len = s.length(), top = -1;
        int[] stack = new int[len];

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(' || top == -1 || s.charAt(stack[top]) != '(') {
                stack[++top] = i;
            } else {
                --top;
            }
        }

        int size = 0, end = len;
        while (top >= 0) {
            int start = stack[top--];

            // (start, end)之间是合法部分，左右都是开区间
            size = Math.max(size, end - start - 1);
            end = start;
        }

        // 栈空了，表示最后一个栈顶的左边都是合法部分了，即[0,end)之间是合法部分，这部分也要参与计算
        size = Math.max(size, end);

        return size;
    }
}
