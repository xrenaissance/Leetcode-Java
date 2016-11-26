package com.inuker.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by dingjikerbo on 16/11/26.
 */

public class LongestAbsoluteFilePath {

    // 耗时4ms
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLen = 0;

        String[] inputs = input.split("\n");
        for (String s : inputs) {
            int lev = s.lastIndexOf("\t") + 1; // 算出\t的个数，\t的个数代表当前目录的深度

            // 要出栈直到当前目录的parent
            while (stack.size() > lev) {
                stack.pop();
            }

            // parent的总长度
            int parentLen = stack.isEmpty() ? 0 : stack.peek();

            // 这里要从s中去掉所有的\t，且合并parent的长度，最后再加上一个'/'
            int len = parentLen + s.length() - lev + 1;

            // 给当前长度也push
            stack.push(len);

            // 最后要返回的是文件的路径长度，而不是目录的长度
            if (s.contains(".")) {
                // 这里要减1因为上面后面加了个'/'，而对于文件是没必要的
                maxLen = Math.max(maxLen, len - 1);
            }
        }

        return maxLen;
    }

    // 下面这种写法简洁一些，其实栈是可以去掉的
    public int lengthLongestPath2(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1;
            stack[lev + 1] = stack[lev] + s.length() - lev + 1;

            if (s.contains(".")) {
                maxLen = Math.max(maxLen, stack[lev + 1] - 1);
            }
        }
        return maxLen;
    }
}
