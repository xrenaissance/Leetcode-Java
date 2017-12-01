package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.Interval;
import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
    }

    class PeekingIterator implements Iterator<Integer> {

        private Integer mNext;

        private Iterator<Integer> mIterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            mIterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (mNext != null) {
                return mNext;
            }
            mNext = mIterator.next();
            return mNext;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (mNext != null) {
                Integer ret = mNext;
                mNext = null;
                return ret;
            }
            return mIterator.next();
        }

        @Override
        public boolean hasNext() {
            return mNext != null || mIterator.hasNext();
        }
    }
}
