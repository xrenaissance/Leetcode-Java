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
        String[] ss = path.split("/");
        Deque<String> queue = new LinkedList<>();
        for (String s : ss) {
            if (s.length() == 0 || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offerLast(s);
            }
        }
        return "/" + String.join("/", queue);
    }
}
