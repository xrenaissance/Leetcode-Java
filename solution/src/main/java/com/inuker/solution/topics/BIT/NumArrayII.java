package com.inuker.solution.topics.BIT;

/**
 * Created by dingjikerbo on 16/11/26.
 */

import com.inuker.solution.SegmentTreeNode;

/**
 * 关于BIT，可以参考http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * 关于Segment Tree，可以参考 https://discuss.leetcode.com/topic/29918/17-ms-java-solution-with-segment-tree
 * https://leetcode.com/articles/range-sum-query-mutable/
 * https://leetcode.com/articles/recursive-approach-segment-trees-range-sum-queries-lazy-propagation/
 * 这题最直观的解法就是Segment Tree递归算法，可以重点关注
 */
public class NumArrayII {

    private SegmentTreeNode mRoot;

    public NumArrayII(int[] nums) {
        mRoot = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }
        int mid = start + ((end - start) >>> 1);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int i, int val) {
        update(mRoot, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        int start = root.start, end = root.end;

        if (start == end) {
            root.sum = val;
            return;
        }
        int mid = start + ((end - start) >>> 1);
        if (i <= mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(mRoot, i, j);
    }

    public int sumRange(SegmentTreeNode root, int i, int j) {
        int start = root.start, end = root.end;

        if (start == i && end == j) {
            return root.sum;
        }

        int mid = start + ((end - start) >>> 1);

        if (j <= mid) {
            return sumRange(root.left, i, j);
        } else if (i > mid) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
        }
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
