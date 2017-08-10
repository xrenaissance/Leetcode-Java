package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] res = new com.inuker.solution.amazon.SlidingWindowMaximum().maxSlidingWindow(new int[] {1, -1}, 1);
        for (Integer n : res) {
            System.out.println(n);
        }
    }
}
