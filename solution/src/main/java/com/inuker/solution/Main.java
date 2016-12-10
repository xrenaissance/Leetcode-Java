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
        int[] arr = new int[] {
                3, 5, 2, 1, 6, 4, 7
        };
        new WiggleSortII().wiggleSort2(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
