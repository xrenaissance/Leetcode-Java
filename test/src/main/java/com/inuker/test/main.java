package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.inuker.solution.WiggleSortII;
import com.leetcode.library.Interval;
import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        int[] arr = new int[] {
                6, 13, 5, 4, 5, 2
        };
        new WiggleSortII().wiggleSort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public void wiggleSort2(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length, j = (n - 1) / 2, k = n - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? arr[j--] : arr[k--];
        }
    }
}
