package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.Interval;
import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
    }

    class MovingAverage {

        private Deque<Integer> mQueue = new LinkedList<>();
        private int mSize;
        private int mSum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            mSize = size;
        }

        public double next(int val) {
            mQueue.offerLast(val);
            mSum += val;
            if (mQueue.size() > mSize) {
                mSum -= mQueue.pollFirst();
            }
            return (double) mSum / mQueue.size();
        }
    }
}
