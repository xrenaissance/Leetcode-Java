package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            List<Integer> list = new com.inuker.solution.amazon.PascalTriangleII()
                    .getRow(i);
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
