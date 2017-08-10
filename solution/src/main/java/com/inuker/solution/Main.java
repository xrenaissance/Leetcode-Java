package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int n = new com.inuker.solution.amazon.WordLadder()
                .ladderLength("hit", "cog", new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(n);
    }
}
