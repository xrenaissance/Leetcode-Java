package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dingjikerbo on 16/12/8.
 */

public class ContainsDuplicateIII {

    /**
     * 这题关键要注意溢出的问题
     * TestCase
     * [-1, 2147483647], k = 1, t = 2147483647
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }

        Map<Long, Integer> map = new HashMap<Long, Integer>();

        for (int i = 0; i < nums.length; i++) {
            long index = ((long) nums[i] - Integer.MIN_VALUE) / ((long) t + 1);
            if (map.containsKey(index) ||
                    (map.containsKey(index - 1) && (long) nums[i] - map.get(index - 1) <= t)
                    || (map.containsKey(index + 1) && map.get(index + 1) - (long) nums[i] <= t)) {
                return true;
            }
            if (map.size() >= k) {
                long index1 = ((long) nums[i - k] - Integer.MIN_VALUE) / (t + 1);
                map.remove(index1);
            }
            map.put(index, nums[i]);
        }

        return false;
     }
}
