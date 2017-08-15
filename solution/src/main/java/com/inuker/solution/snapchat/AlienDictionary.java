package com.inuker.solution.snapchat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by liwentian on 17/8/15.
 */

public class AlienDictionary {

    public String alienOrder(String[] words) {
        int[] indegree = new int[256];
        Arrays.fill(indegree, -1);

        int count = 0;

        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (indegree[c] == -1) {
                    indegree[c] = 0;
                    count++;
                }
            }
        }

        HashMap<Character, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];

            for (int j = 0; j < first.length() && j < second.length(); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    Set<Character> set = map.get(first.charAt(j));
                    if (set == null) {
                        set = new HashSet<>();
                        map.put(first.charAt(j), set);
                    }
                    if (set.add(second.charAt(j))) {
                        indegree[second.charAt(j)]++;
                    }
                    break;
                } else {
                    if (j + 1 < first.length() && j + 1 >= second.length()) {
                        return "";
                    }
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (indegree[c] == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            Set<Character> set = map.get(c);
            if (set != null) {
                for (char cc : set) {
                    if (--indegree[cc] == 0) {
                        queue.offer(cc);
                    }
                }
            }

        }

        if (sb.length() != count) {
            return "";
        }

        return sb.toString();
    }
}
