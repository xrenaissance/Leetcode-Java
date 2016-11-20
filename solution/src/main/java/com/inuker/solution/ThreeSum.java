package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/20.
 */

/**
 * TestCase
 * [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
 *
 */
public class ThreeSum {

    // 耗时30ms
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int sum = -nums[i];

            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int m = nums[j] + nums[k];
                if (m > sum) {
                    k--;
                } else if (m < sum) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (++j, --k; j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]; j++, k--);
                }
            }
        }

        return result;
    }
}
