package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.TreeNode;

import java.util.List;

public class main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{
                20, 10, 40, 5, 15, 30, 60, 2, 7, 12, 18, 25, 35, 50, 70
        });

        List<TreeNode> list = new InorderSuccessorInBST().getAllPredesessor(root, 40);
        for (TreeNode n : list) {
            System.out.print(n.val + " ");
        }
    }

}
