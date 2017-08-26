package com.example;

import com.leetcode.google.SentenceScreenFitting;
import com.leetcode.google.ZigzagIterator;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] texts = {"a", "b"};
        int count = new SentenceScreenFitting().wordsTyping(texts, 20000, 20000);
        System.out.print(count);
    }
}
