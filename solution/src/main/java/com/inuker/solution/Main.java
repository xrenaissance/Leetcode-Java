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
        int n = 226;
        String s = new Test1().convertToTitle(n);
        String s2 = new ExcelSheetColumnTitle().convertToTitle(n);
        System.out.println(s);
        System.out.println(s2);
    }
}
