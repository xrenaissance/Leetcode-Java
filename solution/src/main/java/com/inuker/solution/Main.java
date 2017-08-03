package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] {
                3, 1, null,
        });
        int max = new com.inuker.solution.prac2017.tree.LargestBSTSubtree().largestBSTSubtree(root);
        System.out.println(max);
    }
}
