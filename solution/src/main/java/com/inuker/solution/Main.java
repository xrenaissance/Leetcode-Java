package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> res = new com.inuker.solution.amazon.LetterCombinationsOfAPhoneNumber()
                .letterCombinations("23");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
