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
        int count = new SentenceScreenFitting().wordsTyping(new String[] {
                "abc", "def", "ghi"
        }, 4, 2);
        System.out.println(count);
    }
}
