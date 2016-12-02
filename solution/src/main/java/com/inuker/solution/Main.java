package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1400000000);
        TreeNode root = new TreeNode(1500000000, node, null);
        int value = new ClosestBinarySearchTreeValue().closestValue(root, -1500000000.0);
        System.out.println(value);
    }

}
