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
        int gap = new MaximumGap().maximumGap(new int[] {
                3,6,9,1
        });
        System.out.println(String.format("gap is %d", gap));
    }
}
