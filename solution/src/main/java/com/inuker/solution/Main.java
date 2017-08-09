package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new com.inuker.solution.amazon.FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc");
        for (Integer n : list) {
            System.out.println(n);
        }
    }
}
