package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("abc");
        dic.addWord("def");
        System.out.println(dic.search(".eg"));
    }
}
