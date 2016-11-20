package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        int len = sb.length();
        sb.append("hello");
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        sb.setLength(len);
        System.out.println(System.nanoTime() - start);


    }


}
