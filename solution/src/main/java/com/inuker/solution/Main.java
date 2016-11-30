package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(4, node1, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, node4, node2);

        new RecoverBinarySearchTree().recoverTree(node3);
        helper(node3);
    }

    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        System.out.println(root.val);
        helper(root.right);
    }
}
