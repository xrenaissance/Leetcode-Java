package com.example;


import com.inuker.solution.BinaryTreePreorderTraversal;
import com.inuker.solution.PathSumIII;
import com.leetcode.library.TreeNode;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode nodef32 = new TreeNode(-3);
        TreeNode node32 = new TreeNode(3, nodef32, null);
        TreeNode nodef2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(11);

        TreeNode node3 = new TreeNode(3, node32, nodef2);
        TreeNode node2 = new TreeNode(2, null, node1);

        TreeNode node5 = new TreeNode(5, node3, node2);
        TreeNode nodef3 = new TreeNode(-3, null, node11);

        TreeNode root = new TreeNode(10, node5, nodef3);

//        List<Integer> list = new BinaryTreePreorderTraversal().preorderTraversal(root);
//        for (Integer n : list) {
//            System.out.print(n + " ");
//        }

        List<String> paths = pathSum(root, 8);
        for (String s : paths) {
            System.out.println(s);
        }
    }

    public static List<String> pathSum(TreeNode root, int sum) {
        List<String> result = new LinkedList<>();
        pathSum(root, sum, result, "");
        return result;
    }

    private static void pathSum(TreeNode root, int sum, List<String> list, String path) {
        if (root == null) {
            return;
        }

        pathSumWithRoot(root, sum, list, path);

        pathSum(root.left, sum, list, "");
        pathSum(root.right, sum, list, "");
    }

    private static void pathSumWithRoot(TreeNode root, int sum, List<String> list, String path) {
        if (root == null) {
            return;
        }

        String prefix = path.isEmpty() ? "" : path + "->";

        if (root.val == sum) {
            list.add(prefix + root.val);
        }
        pathSumWithRoot(root.left, sum - root.val, list, prefix + root.val);
        pathSumWithRoot(root.right, sum - root.val, list, prefix + root.val);
    }
}

