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
        List<List<String>> words = new WordSquare().wordSquares(new String[] {
                "area","lead","wall","lady","ball"
        });
        for (List<String> list : words) {
            for (String word : list) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
