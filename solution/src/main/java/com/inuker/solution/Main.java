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
        int min = new PaintHouseII().minCostII3(new int[][] {
                {1, 5, 3},
                {2, 9, 4}
        });
        System.out.println(min);
    }
}
