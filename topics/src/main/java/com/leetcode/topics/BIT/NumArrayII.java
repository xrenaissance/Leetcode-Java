package com.leetcode.topics.BIT;

/**
 * Created by dingjikerbo on 16/11/26.
 */

public class NumArrayII {

    private int[] bit;

    private int[] nums;

    public NumArrayII(int[] nums) {
        this.nums = nums;

        bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    private void init(int i, int val) {
        i++;
        while (i < bit.length) {
            bit[i] += val;
            i += i & (-i);
        }
    }

    private int getSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
       return getSum(j) - getSum(i - 1);
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
