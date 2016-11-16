package com.inuker.solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> result = new LetterCombinationOfPhoneNumber().letterCombinations("132");
        for (String t : result) {
            System.out.println(String.format("[%s]", t));
        }

    }
}
