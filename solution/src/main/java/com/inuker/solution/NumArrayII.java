package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/26.
 */

public class NumArrayII {

    private int[] mNums;
    private int[] mBITTree;

    public NumArrayII(int[] nums) {
        mNums = nums;
        mBITTree = constructBITree(nums);
    }

    public void update(int i, int val) {
        updateBIT(mBITTree, i, val - mNums[i]);
        mNums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(mBITTree, j) - getSum(mBITTree, i - 1);
    }

    private int[] constructBITree(int[] arr) {
        int[] tree = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            updateBIT(tree, i, arr[i]);
        }
        return tree;
    }

    private void updateBIT(int tree[], int index, int val) {
        for (index++; index < tree.length; index += getLowbit(index)) {
            tree[index] += val;
        }
    }

    private int getSum(int tree[], int index) {
        int sum = 0;
        for (index++; index > 0; index -= getLowbit(index)) {
            sum += tree[index];
        }
        return sum;
    }

    // 只剩下最低的1，其余高位1都清零
    private int getLowbit(int n) {
        return n & -n;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
