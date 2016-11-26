package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        NumArrayII s = new NumArrayII(new int[] {
                7,2,7,2,0
        });
        int[] oper = {0, 0, 0, 1, 0, 1, 0, 1, 1, 0};
        int[][] nums = {
                {4, 6}, {0, 2}, {0, 9}, {3, 8}, {4, 1}, {0, 4}, {4, 4}, {0, 4}, {0, 3}, {0, 4}
        };
        for (int i = 0; i < oper.length; i++) {
            if (oper[i] == 1) {
                System.out.println(s.sumRange(nums[i][0], nums[i][1]));
            } else {
                s.update(nums[i][0], nums[i][1]);
            }
        }
    }
}
