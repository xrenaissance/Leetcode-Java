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
        Test1.RandomizedCollection s = new Test1.RandomizedCollection();
        s.insert(4);
        s.insert(3);
        s.insert(4);
        s.insert(2);
        s.insert(4);
        s.remove(4);
        s.remove(3);
        s.remove(4);
        s.remove(4);
    }
}
