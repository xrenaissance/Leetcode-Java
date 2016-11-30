package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        new FlattenBinaryTreeToLinkedList().flatten(node1);
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.right;
        }
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
