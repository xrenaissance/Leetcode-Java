package com.inuker.solution;

import com.inuker.solution.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[] {
                1, null, 2
        });
        String t = new Solution().serialize(root);
        System.out.println(t);

        root = new Solution().deserialize(t);
        List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal2(root);
        for (Integer n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
        List<Integer> result2 = new BinaryTreeInorderTraversal().inorderTraversal(root);
        for (Integer n : result2) {
            System.out.print(n + " ");
        }



    }
}
