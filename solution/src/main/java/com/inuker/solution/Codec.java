package com.inuker.solution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 * 按先序遍历
 */

/**
 * 要注意的是分隔符不要加重复了，比如1,X,,X这样的，重复的话在split时会有空串
 * 分递归版和非递归版，递归版的如果树大了可能栈溢出
 */
public class Codec {
    // 这里的分隔符是有讲究的，如果换成'.'则在split的时候要转义，但是','不用
    private static final String SEP = ",";

    // 这个尽可能短，节省空间
    private static final String NULL = "X";

    /** 递归版的 */
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

    /** 下面是非递归版的DFS */
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(NULL);
            return sb.toString();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                sb.append(root.val);
                stack.push(root);
                root = root.left;
            } else {
                sb.append(NULL);
                root = stack.pop().right;
            }

            sb.append(SEP);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] texts = data.split(SEP);
        Queue<String> queue = new LinkedList<String>(Arrays.asList(texts));
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = getNode(queue), node = root;

        while (!queue.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                node.right = getNode(queue);
                node = node.right;
            } else {
                stack.push(node);
                node.left = getNode(queue);
                node = node.left;
            }
        }

        return root;
    }

    private TreeNode getNode(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String text = queue.poll();
        if (text.equals(NULL)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(text));
    }

    /**
     * BFS版的
     */
    public String serialize3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(NULL);
            return sb.toString();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(node.val).append(SEP);
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize3(String data) {
        String[] text = data.split(SEP);
        if (text.length == 0 || text[0].equals(NULL)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(text[0]));
        queue.add(root);
        for (int i = 1; i < text.length; i++) {
            TreeNode node = queue.poll();
            if (!text[i].equals(NULL)) {
                node.left = new TreeNode(Integer.parseInt(text[i]));
                queue.add(node.left);
            }
            if (!text[++i].equals(NULL)) {
                node.right = new TreeNode(Integer.parseInt(text[i]));
                queue.add(node.right);
            }
        }
        return root;
    }
}
