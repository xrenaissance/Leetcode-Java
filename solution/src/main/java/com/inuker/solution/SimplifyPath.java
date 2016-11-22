package com.inuker.solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else if (!str.isEmpty() && !str.equals(".")) {
                queue.offerLast(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(String.format("/%s", queue.poll()));
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
