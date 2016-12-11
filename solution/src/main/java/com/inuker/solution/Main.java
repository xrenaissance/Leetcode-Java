package com.inuker.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        List<Integer> counts = new NumberOfIslandsII().numIslands2(3, 3, new int[][] {
                {0,0}, {0,1}, {1,2}, {2,1}
        });
        for (Integer n : counts) {
            System.out.print(n + " ");
        }
    }
}
