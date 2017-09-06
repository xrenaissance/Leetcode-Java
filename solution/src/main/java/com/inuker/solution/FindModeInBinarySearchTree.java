package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/3.
 */

/**
 * 这题是要找BST中出现次数最多的节点集合，这里允许有重复节点
 * 思路很简单，中序遍历，会按升序排列，再统计重复的值
 */
public class FindModeInBinarySearchTree {

    private List<Integer> mList;

    private int mCurCount;

    private int mMaxCount;

    private Integer mCurValue;

    public int[] findMode(TreeNode root) {
        mList = new LinkedList<>();

        inorderTraverse(root);

        int[] res = new int[mList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);


        if (mCurValue != null && root.val != mCurValue) {
            mCurCount = 1;
        } else {
            mCurCount++;
        }

        mCurValue = root.val;

        if (mCurCount > mMaxCount) {
            mList.clear();
            mList.add(mCurValue);
            mMaxCount = mCurCount;
        } else if (mCurCount == mMaxCount) {
            mList.add(mCurValue);
        }

        inorderTraverse(root.right);
    }
}
