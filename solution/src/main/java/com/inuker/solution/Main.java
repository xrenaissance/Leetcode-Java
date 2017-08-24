package com.inuker.solution;

public class Main {

    public static void main(String[] args) {
//        String n = new com.inuker.solution.company.facebook.IntegerToEnglishWords().numberToWords(50878);
//        System.out.println("(" + n + ")");

        int n = 5; // 01, 11,
        // 01, 11
        // 00, 00
        // 10, 10
        // 11, 01
        System.out.println(n & (-n));
    }
}
