package com.inuker.solution;

public class Main {

    public static void main(String[] args) {
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(new int[] {
                1,2,3,4
        });
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
