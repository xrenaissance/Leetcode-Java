package com.inuker.solution;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/**
 * TestCases
 [1,-1] 1
 [7,2,4] 2
 [1,3,1,2,0,5] 3
 */
public class SlidingWindowMaximum {

    /**
     * 注意PriorityQueue的remove复杂度是O(k)，所以本题复杂度是O(n*k)
     * 可以将PriorityQueue转成TreeMap，复杂度为O(n*lgk)
     */
    // 耗时58ms
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peek();

        for (int i = 1; i < result.length; i++) {
            queue.remove(nums[i - 1]);
            queue.offer(nums[i + k - 1]);
            result[i] = queue.peek();
        }

        return result;
    }

    // 耗时23ms
    // queue中存的是索引
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> queue = new LinkedList<Integer>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }

        return result;
    }
}
