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
        char[][] chars = new char[][] {
                "OXXOX".toCharArray(),
                "XOOXO".toCharArray(),
                "XOXOX".toCharArray(),
                "OXOOO".toCharArray(),
                "XXOXO".toCharArray()
        };
        new SurroundedRegions().solve(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
