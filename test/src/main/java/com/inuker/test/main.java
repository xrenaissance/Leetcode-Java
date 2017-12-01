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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        ZigzagIterator iterator = new ZigzagIterator(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6,7),
                Arrays.asList(8,9));
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public static class ZigzagIterator {

        private List<Iterator<Integer>> mIterators;
        private int mIndex;

        public ZigzagIterator(List<Integer>... args) {
            mIterators = new LinkedList<>();
            for (List<Integer> list : args) {
                if (!list.isEmpty()) {
                    mIterators.add(list.iterator());
                }
            }
        }

        public int next() {
            mIndex %= mIterators.size();
            Iterator<Integer> iterator = mIterators.get(mIndex);
            int n = iterator.next();
            if (!iterator.hasNext()) {
                mIterators.remove(iterator);
            } else {
                mIndex++;
            }
            return n;
        }

        public boolean hasNext() {
            return !mIterators.isEmpty();
        }
    }
}
