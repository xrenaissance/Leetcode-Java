package com.inuker.solution.test;

import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    private static final String NULL = "#";
    private static final String SEP = ",";

    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + SEP);
        sb.append(serialize(root.left) + SEP);
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(vals));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String text = queue.poll();
        if (text.equals(NULL)) {
            return null;
        }
        int val = Integer.valueOf(text);
        TreeNode root = new TreeNode(val);
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
