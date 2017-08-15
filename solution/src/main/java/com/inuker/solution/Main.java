package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = new com.inuker.solution.snapchat.CombinationSum()
                .combinationSum(new int[] {
                        2, 3, 6, 7
                }, 7);
        for (List<Integer> list : result) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
