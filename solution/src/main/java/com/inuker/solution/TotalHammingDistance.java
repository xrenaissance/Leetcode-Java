package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/1/7.
 */

public class TotalHammingDistance {
    /**
     * 思路是依次遍历每个数字的第i位，统计出为1的有m个，为0的有n个，则在这一位上
     * 增加的hamming distance为m*n个
     */
    /**
     * 复杂度为O(n)
     */
    public int totalHammingDistance(int[] nums) {
        int cnt = 0;
        for (int i = 0, j, k; i < 32; i++) {
            for (j = 0, k = 0; j < nums.length; j++) {
                k += nums[j] & 1;
                nums[j] >>>= 1;
            }
            cnt += k * (nums.length - k);
        }
        return cnt;
    }
}
