package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liwentian on 2016/11/16.
 */

/** TestCases
 TreeNode root = new TreeNode(1);
 Codec code = new Codec();
 String data = code.serialize(root);
 System.out.println(data);
 TreeNode node = code.deserialize(data);
 System.out.println(String.format("%d, %s, %s", node.val, node.left, node.right));
 */
public class Codec {

    // 这里的分隔符是有讲究的，如果换成'.'则在split的时候要转义，但是','不用
    private static final String SEP = ".";

    // 这个尽可能短，节省空间
    private static final String NULL = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
        } else {
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(SEP)));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String s = queue.poll();

        if (s.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
