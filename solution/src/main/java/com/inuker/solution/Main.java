package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String s = new IntegerToEnglishWords().numberToWords(1100000);
        System.out.println(String.format("[%s]", s));
    }


}
