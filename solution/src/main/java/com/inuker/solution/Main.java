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
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));
        List<List<String>> result = new Test1().findLadders("a", "c", set);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
