package com.inuker.solution;

import com.inuker.solution.test.Test1;
import com.inuker.solution.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[] {
                1, 1, 2, 2, 3, 3
        }, 6);
        for (List<Integer> list : result) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
