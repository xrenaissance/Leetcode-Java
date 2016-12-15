package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/** TestCases
 TreeNode root = new TreeNode(1);
 Codec code = new Codec();
 String data = code.serialize(root);
 System.out.println(data);
 TreeNode node = code.deserialize(data);
 System.out.println(String.format("%d, %s, %s", node.val, node.left, node.right));
 */

/**
 * 要注意的是分隔符不要加重复了，比如1,X,,X这样的，重复的话在split时会有空串
 */
public class Codec {

    // 这里的分隔符是有讲究的，如果换成'.'则在split的时候要转义，但是','不用
    private static final String SEP = ".";

    // 这个尽可能短，节省空间
    private static final String NULL = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.val).append(SEP);
            sb.append(serialize(root.left)).append(SEP);
            sb.append(serialize(root.right));
        } else {
            sb.append(NULL);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] texts = data.split(SEP);
        Queue<String> queue = new LinkedList<String>(Arrays.asList(texts));
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
