package com.inuker.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class KthLargestElementInArray {

    // 耗时16ms，时间复杂度O(nlgk)，空间复杂度O(k)
    // 按降序排的，出队列k次获取第k大的数
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }

    // 耗时3ms，时间复杂度O(nlgn)，空间复杂度O(l)
    public int findKthLargest3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 快速选择，平均时间复杂度为O(n)
    // T(n) = T(n / 2) + n = O(2n)
    // 对比快速排序T(n) = 2T(n / 2) + n = O(nlgn)
    // 区别在于这个被pivot分隔后，只用处理其中的一半，而快排两边都要处理
    // 耗时18ms
    public int findKthLargest4(int[] nums, int k) {
        return nums[findKthLargest4(nums, 0, nums.length - 1, k)];
    }

    public int findKthLargest4(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);

        int rank = end - pivot + 1;

        if (rank == k) {
            return pivot;
        } else if (rank > k) {
            return findKthLargest4(nums, pivot + 1, end, k);
        } else {
            return findKthLargest4(nums, start, pivot - 1, k - rank);
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

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
