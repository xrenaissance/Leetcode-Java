package com.inuker.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by dingjikerbo on 2016/12/21.
 */

public class CountOfSmallerNumbersAfterSelf {

    /**
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ret = new Integer[nums.length];
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            Integer[] result = vector.toArray(new Integer[0]);
            int index = binarySearch(result, nums[i]);
            if (index < 0) {
                index = - (index + 1);
            }
            ret[i] = index;
            vector.insertElementAt(nums[i], index);
        }
        return Arrays.asList(ret);
    }

    private int binarySearch(Integer[] nums, int n) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (n > nums[mid]) {
                left = mid + 1;
            } else if (n <= nums[mid]) {
                right = mid - 1;
            }
        }
        if (left == nums.length || nums[left] != n) {
            return - (left + 1);
        }
        return left;
    }
     */

    class Node {
        Node left, right;
        int val, sum, dup = 1;

        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (num < node.val) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
