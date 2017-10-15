package com.example;

import com.inuker.solution.ContainsDuplicateIII;

public class Main {

    public static void main(String[] args) {
        int[] nums = {
            1, 3, 1
        };
        boolean result = new ContainsDuplicateIII().containsNearbyAlmostDuplicate2(nums, 1, 1);
        System.out.println(result);
    }
}
