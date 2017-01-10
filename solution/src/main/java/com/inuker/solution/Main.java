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
        int[] colors = {
                0, 1, 3, 2, 3,2, 2, 2,3,1, 0, 1, 1, 1, 1, 1, 0
        };
        int[] color2 = colors.clone();
        Arrays.sort(color2);
        for (int n : color2) {
            System.out.print(n + " ");
        }
        System.out.println();

        SortColors sort = new SortColors();
        sort.sortKColors(colors, 4);
        for (int n : colors) {
            System.out.print(n + " ");
        }
    }
}
