package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by liwentian on 2017/10/15.
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            long n = nums[i];
            Long s = set.ceiling(n);
            if (s != null && s <= n + t) return true;

            Long g = set.floor(n);
            if (g != null && n <= g + t) return true;

            set.add(n);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
