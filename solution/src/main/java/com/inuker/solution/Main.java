package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] {
                10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
        });
        List<Integer> list = new BinaryTreePreorderTraversal().preorderTraversal2(root);
        for (Integer n : list) {
            System.out.print(n + " ");
        }
        new com.inuker.solution.prac2017.tree.PathSumIII().pathSum(root, 8);
    }
}
