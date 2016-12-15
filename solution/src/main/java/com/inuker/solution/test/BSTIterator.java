package com.inuker.solution.test;

import com.inuker.solution.TreeNode;

import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/15.
 */

public class BSTIterator {

    private Stack<TreeNode> mStack;
    private TreeNode mCur;

    public BSTIterator(TreeNode root) {
        mStack = new Stack<TreeNode>();
        mCur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.isEmpty() || mCur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (hasNext()) {
            if (mCur != null) {
                mStack.push(mCur);
                mCur = mCur.left;
            } else {
                mCur = mStack.pop();
                int val = mCur.val;
                mCur = mCur.right;
                return val;
            }
        }
        return 0;
    }
}
