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
 * 这题重要的是查重
 */
public class ThreeSum {

    // 耗时30ms
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    /**
                     * 别给j < k掉了
                     */
                    for (j++, k-- ; j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]; j++, k--);
                }
            }
        }
        return result;
    }
}
