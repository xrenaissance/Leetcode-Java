package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/12/10.
 */

/**
 * TestCase
 * [1,2,2,1,2,1,1,1,1,2,2,2]
 */
public class WiggleSortII {

    public void wiggleSort2(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length, k = (n - 1) / 2, j = n - 1;
        for (int i = 0; i < n; i++) {
            nums[i] = (i & 1) != 0 ? arr[j--] : arr[k--];
        }
    }

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int median = findKthLargest(nums, (len + 1) / 2);
        for (int left = 0, right = len - 1, i = 0; i <= right; ) {
            if (nums[newIndex(i, len)] > median) {
                swap(nums, newIndex(left++, len), newIndex(i++, len));
            } else if (nums[newIndex(i, len)] < median) {
                swap(nums, newIndex(right--, len), newIndex(i, len));
            } else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest(int[] nums, int k) {
        return nums[findKthLargest(nums, 0, nums.length - 1, k)];
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);

        int rank = end - pivot + 1;

        if (rank == k) {
            return pivot;
        } else if (rank > k) {
            return findKthLargest(nums, pivot + 1, end, k);
        } else {
            return findKthLargest(nums, start, pivot - 1, k - rank);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end], left = start;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, left++, i);
            }
        }

        swap(nums, left, end);

        return left;
    }
}
