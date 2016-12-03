package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode nodef2 = new TreeNode(-2, null, null);
        TreeNode node3k = new TreeNode(3, node3, nodef2);
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, node1);
        TreeNode node5 = new TreeNode(5, node3k, node2);
        TreeNode node11 = new TreeNode(11, null, null);
        TreeNode nodef3 = new TreeNode(-3, null, node11);
        TreeNode node10 = new TreeNode(10, node5, nodef3);
        inorder(node10);
        System.out.println();
        int count = new PathSumIII().pathSum(node10, 8);
        System.out.println(String.format("count is %d", count));
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

}
