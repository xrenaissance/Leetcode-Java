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
//        List<List<Integer>> result = new Test1().subsets(new int[] {
//                4,4,4,1,4
//        });
//        for (List<Integer> list : result) {
//            for (Integer n : list) {
//                System.out.print(n + " ");
//            }
//            System.out.println();
//        }
        boolean k = new Test1().canFinish(3, new int[][] {
                {1,0},{2,1}
        });
        System.out.println(k);
    }
}
