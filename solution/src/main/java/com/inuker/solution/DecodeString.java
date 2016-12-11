package com.inuker.solution;

import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

public class DecodeString {

    /**
     * 两种思路，递归和栈
     */

    // 耗时3ms，性能很好，思路很直观
    // 以[]内的为递归对象
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < '0' || c > '9') {
                sb.append(c);
                continue;
            }

            // 先解析数字
            int index = s.indexOf('[', i + 1);
            int digit = Integer.valueOf(s.substring(i, index));
            i = index + 1;

            for (int count = 1; count != 0; i++) {
                if (s.charAt(i) == '[') {
                    count++;
                } else if (s.charAt(i) == ']') {
                    count--;
                }
            }

            String str = decodeString(s.substring(index + 1, --i));
            for ( ; digit > 0; digit--, sb.append(str));
        }

        return sb.toString();
    }

    // 耗时4ms
    public String decodeString2(String s) {
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0, digit = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                digit = digit * 10 + (c - '0');
            } else if (c == '[') {
                intStack.push(digit);
                digit = 0;
                strStack.push(cur);
                cur = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (int k = intStack.pop(); k > 0; k--) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
