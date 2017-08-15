package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = new com.inuker.solution.combination.CombinationSumIII()
                .combinationSum3(3, 9);
        for (List<Integer> list : result) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
