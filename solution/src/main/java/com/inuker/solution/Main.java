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
        FindMedianFromDataStream s = new FindMedianFromDataStream();
        s.addNum(1);
        s.addNum(2);
        s.addNum(3);
        s.addNum(4);
        double f = s.findMedian();
        System.out.println(f);
    }
}
