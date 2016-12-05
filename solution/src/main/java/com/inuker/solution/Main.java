package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] {
                1, -2, -3, 1, 3, -2, null, -1
        });
        int count = new PathSumIII().pathSum(root, -1);
        System.out.println(String.format("count is %d", count));
    }
}
