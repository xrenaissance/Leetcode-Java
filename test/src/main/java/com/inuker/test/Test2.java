package com.inuker.test;

import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by liwentian on 2017/12/5.
 */

public class Test2 {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = nums.length - 1; j > i; ) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] != 0) {
                swap(nums, i, j--);
            } else {
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
