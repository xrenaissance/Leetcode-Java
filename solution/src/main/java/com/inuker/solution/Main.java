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
                4,5,5,6
        };
        new WiggleSortII().wiggleSort2(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
