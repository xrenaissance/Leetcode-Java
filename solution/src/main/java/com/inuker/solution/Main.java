package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        new SortColors().sortColors3(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }


}
