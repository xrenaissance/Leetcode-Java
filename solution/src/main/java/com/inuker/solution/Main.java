package com.inuker.solution;

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
        List<Integer> result = new CountOfSmallerNumbersAfterSelf().countSmaller(new int[] {
                5,7,6,3,4,8
        });
        for (Integer n : result) {
            System.out.print(n + " ");
        }
    }
}
