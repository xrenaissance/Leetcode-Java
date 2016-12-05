package com.inuker.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] {
               7,6,8,4,null,null,12,3,5
        });
//        int count = new PathSumIII().pathSum(root, -1);
//        System.out.println(String.format("count is %d", count));

        ArrayList<Integer> s1 = new ArrayList<>(); // predecessors
        ArrayList<Integer> s2 = new ArrayList<>(); // successors

        inorder(root, 4, false, s1);

        for (Integer n : s1) {
            System.out.print(n + " ");
        }

        inorder(root, 4, true, s2);
        System.out.println();

        for (Integer n : s2) {
            System.out.print(n + " ");
        }
    }

    static void inorder(TreeNode root, double target, boolean reverse, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(reverse ? root.right : root.left, target, reverse, list);
        // early terminate, no need to traverse the whole tree
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        // track the value of current node
        list.add(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, list);
    }
}
