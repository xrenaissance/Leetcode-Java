package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = new ThreeSum().threeSum(new int[] {
                -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0
        });
        for (List<Integer> list : result) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


}
