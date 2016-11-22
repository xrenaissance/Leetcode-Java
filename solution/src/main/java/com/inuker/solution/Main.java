package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = new SubsetsII().subsetsWithDup(new int[] {
                1,2,2
        });
        for (List<Integer> list : result) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


}
