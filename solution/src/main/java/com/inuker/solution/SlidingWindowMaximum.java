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
     * 可以将PriorityQueue转成TreeMap
     */
    // 耗时62ms
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        });

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

            // 别忘了加限制条件
            if (i >= k) {
                queue.remove(nums[i - k]);
            }

            // 别忘了加限制条件
            if (i >= k - 1) {
                result[i - k + 1] = queue.peek();
            }
        }

        return result;
    }

    // 耗时26ms
    // queue中存的是索引
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<Integer>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.getFirst() <= i - k) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }

        return result;
    }
}
