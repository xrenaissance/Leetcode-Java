package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

/**
 * TestCase
 * ""
 * "x("
 * "("
 */
public class RemoveInvalidParentheses {

    /**
     * BFS法，遍历s，依次去掉一个'('或')'，然后加入队列，判断是否是合法序列
     * 遇到合法序列，则将该层所有序列都找出来
     */
    // 耗时97ms
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        List<String> result = new LinkedList<String>();

        queue.add(s);
        while (!queue.isEmpty()) {
            String ss = queue.poll();
            if (isValidParentheses(ss)) {
                result.add(ss);
            } else {
                for (int i = 0; i < ss.length(); i++) {
                    if (ss.charAt(i) != '(' && ss.charAt(i) != ')') {
                        continue;
                    }
                    String st = ss.substring(0, i) + ss.substring(i + 1);
                    if (visited.add(st)) {
                        next.add(st);
                    }
                }
            }

            if (queue.isEmpty() && result.isEmpty()) {
                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }

    private boolean isValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                // 这里要注意如果中途count<0了就非法了
                if (--count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    // 耗时9ms，时间复杂度仍然是O(n*2^n)，只不过这里剪枝很多
    public List<String> removeInvalidParentheses2(String s) {
        if (s.length() == 0) {
            return Arrays.asList("");
        }
        int nL = 0, nR = 0;
        char[] ss = s.toCharArray();
        for (char c : ss) {
            if (c == '(') {
                nL++;
            } else if (c == ')') {
                if (nL > 0) {
                    nL--;
                } else {
                    nR++;
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        dfs(s, 0, set, new StringBuilder(), nL, nR, 0);
        return new LinkedList<String>(set);
    }

    private void dfs(String s, int i, HashSet<String> set, StringBuilder sb, int nL, int nR, int count) {
        if (nL < 0 || nR < 0 || count < 0) {
            return;
        }

        if (i == s.length()) {
            if (nL == 0 && nR == 0 && count == 0) {
                set.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(i);
        int len = sb.length();

        // 要注意下面都要先处理不带c，再处理带c的情况
        if (c == '(') {
            dfs(s, i + 1, set, sb, nL - 1, nR, count);
            dfs(s, i + 1, set, sb.append(c), nL, nR, count + 1);
        } else if (c == ')') {
            dfs(s, i + 1, set, sb, nL, nR - 1, count);
            dfs(s, i + 1, set, sb.append(c), nL, nR, count - 1);
        } else {
            dfs(s, i + 1, set, sb.append(c), nL, nR, count);
        }

        sb.setLength(len);
    }
}
