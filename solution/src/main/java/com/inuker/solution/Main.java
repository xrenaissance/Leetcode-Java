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
        boolean flag = new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[] {
                -1, Integer.MAX_VALUE
        }, 1, Integer.MAX_VALUE);
        System.out.println(flag);
    }
}
