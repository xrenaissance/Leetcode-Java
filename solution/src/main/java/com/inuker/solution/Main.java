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
        LFUCache cache = new LFUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.get(1);
        cache.set(3, 3);
        cache.get(2);
        cache.get(3);
        cache.set(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
