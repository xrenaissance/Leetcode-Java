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

        String word = new Test1().alienOrder(new String[] {
                "wrt","wrf","er","ett","rftt"
        });
        System.out.println(String.format("(%s)", word));
    }
}
