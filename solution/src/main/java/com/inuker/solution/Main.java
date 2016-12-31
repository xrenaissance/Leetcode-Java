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
        int max = new Test1().maximalRectangle(new char[][] {
                "10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()
        });
        System.out.println(max);
    }
}
