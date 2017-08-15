package com.inuker.solution.tree;

import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liwentian on 17/7/14.
 */

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.val).append(",");
            sb.append(serialize(root.left)).append(",");
            sb.append(serialize(root.right));
        } else {
            sb.append("X");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] texts = data.split(",");
        List<String> queue = new ArrayList<>(Arrays.asList(texts));
        return helper(queue);
    }

    private TreeNode helper(List<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.remove(0);
        if (s.isEmpty() || s.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
