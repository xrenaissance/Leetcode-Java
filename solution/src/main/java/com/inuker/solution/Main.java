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
        TreeNode node = TreeNode.buildTree(new Integer[] {
            3, 9, 20, 15, 7
        });
        List<List<Integer>> list = new Solution().verticalOrder(node);
        for (List<Integer> l : list) {
            for (Integer n : l) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
