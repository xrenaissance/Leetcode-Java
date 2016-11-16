package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class ValidParentheses {

    // 耗时5ms
    public boolean isValid(String s) {
        char[] ss = s.toCharArray();

        char[] stack = new char[ss.length];
        int top = -1;

        for (char c : ss) {
            if ("{([".indexOf(c) >= 0) {
                stack[++top] = c;
                continue;
            }

            switch (c) {
                case ')':
                    if (top < 0 || stack[top--] != '(') {
                        return false;
                    }
                    break;

                case '}':
                    if (top < 0 || stack[top--] != '{') {
                        return false;
                    }
                    break;

                case ']':
                    if (top < 0 || stack[top--] != '[') {
                        return false;
                    }
                    break;
            }
        }

        return top < 0;
    }
}
