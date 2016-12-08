package com.inuker.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Collections.shuffle();
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
