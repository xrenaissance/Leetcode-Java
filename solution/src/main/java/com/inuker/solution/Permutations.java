package com.inuker.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liwentian on 2016/12/17.
 */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        permute(nums, result, path, 0);
        return result;
    }

    public void permute(int[] nums, List<List<Integer>> result,
                        List<Integer> path, int start) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (Integer n : nums) {
                list.add(n);
            }
            result.add(list);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, result, path, start + 1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /** 第二种写法
    public List<List<Integer>> permute2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        permute(nums, result, path);
        return result;
    }

    public void permute(int[] nums, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            permute(nums, result, path);
            path.remove(path.size() - 1);
        }
    }
     */
}
