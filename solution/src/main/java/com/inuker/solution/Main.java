package com.inuker.solution;

public class Main {

    public static void main(String[] args) {
        int[] result = new SlidingWindowMaximum().maxSlidingWindow2(new int[] {
               1,3,1,2,0,5
        }, 3);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
