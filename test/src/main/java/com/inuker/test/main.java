package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{
                2, 1
        });

        List<Integer> list = closestKValues(root, 4.14, 2);
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }

    int mMaxCount;
    int mCurVal;
    int mCurCount;
    int mMaxElemSize;

    int idx;

    public int[] findMode(TreeNode root) {
        helper(root);
        int[] result = new int[mMaxElemSize];
        mCurCount = 0;
        unite(root, result);
        return result;
    }

    private void unite(TreeNode node, int[] result) {
        if (node == null) {
            return;
        }
        unite(node.left, result);

        if (node.val == mCurVal) {
            mCurCount++;
        } else {
            mCurCount = 1;
            mCurVal = node.val;
        }

        if (mCurCount == mMaxCount) {
            result[idx++] = mCurVal;
        }

        unite(node.right, result);
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        if (node.val == mCurVal) {
            mCurCount++;
        } else {
            mCurCount = 1;
            mCurVal = node.val;
        }

        if (mCurCount == mMaxCount) {
            mMaxElemSize++;
        } else if (mCurCount > mMaxCount) {
            mMaxElemSize = 1;
            mMaxCount = mCurCount;
        }

        helper(node.right);
    }
}
