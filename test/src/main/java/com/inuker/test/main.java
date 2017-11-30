package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.leetcode.library.TreeNode;

import java.util.List;

public class main {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node5, node4);
        TreeNode node2 = new TreeNode(2, node3, null);


        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal2(node2);
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = null;
        while (root != null) {
            if (p.val < root.val) {
                node = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return node;
    }
}
