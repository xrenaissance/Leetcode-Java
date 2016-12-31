package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        int left = max, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = getCount(nums, mid);
            if (count > m) {
                left = mid + 1;
            } else if (count <= m) {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getCount(int[] nums, int k) {
        int sum = 0, count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > k) {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}
