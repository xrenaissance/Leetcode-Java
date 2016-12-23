package com.inuker.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * TestCases
 * "a", "c", ["a", "b", "c"]
 * "hit", "cog", ["hot","cog","dot","dog","hit","lot","log"]
 * "hit", "cog", ["hot","hit","cog","dot","dog"]
 * "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
 */
public class WordLadderII {

    private int mMin = -1;

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();
        bfs2(start, end, dict, map);

//        System.out.println(mMin);
//        for (String key : map.keySet()) {
//            System.out.print(key + ": ");
//            for (String word : map.get(key)) {
//                System.out.print(word + " ");
//            }
//            System.out.println();
//        }

        List<List<String>> result = new LinkedList<List<String>>();
        List<String> path = new LinkedList<>(Arrays.asList(start));
        dfs(start, end, map, result, path);
        return result;
    }

    private void bfs2(String start, String end, Set<String> dict, HashMap<String, Set<String>> map) {
        Queue<String> queue = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        int length = 1;
        queue.add(start);
        dict.add(end);
        while (!queue.isEmpty()) {
            String word = queue.poll();

            Set<String> set = map.get(word);
            if (set == null) {
                set = new HashSet<String>();
                map.put(word, set);
            }

            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if (j + 'a' == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) (j + 'a'));
                    String t = sb.toString();

                    if (t.equals(end)) {
                        mMin = length + 1;
                    }

                    if (dict.contains(t)) {
                        set.add(t);
                        next.add(t);
                    }
                }
                sb.setCharAt(i, c);
            }

            if (queue.isEmpty() && mMin == -1) {
                queue.addAll(next);
                next.clear();
                length++;
            }
        }
    }

    private void dfs(String start, String end, Map<String, Set<String>> map, List<List<String>> result, List<String> path) {
        if (start.equals(end)) {
            result.add(new ArrayList<String>(path));
            return;
        }

        if (path.size() >= mMin) {
            return;
        }

        Set<String> words = map.get(start);
        for (String word : words) {
            if (path.contains(word)) {
                continue;
            }
            path.add(word);
            dfs(word, end, map, result, path);
            path.remove(path.size() - 1);
        }
    }

    //    private void bfs(String start, String end, Set<String> dict, HashMap<String, Set<String>> map) {
//        Set<String> visited = new HashSet<String>();
//        dict.add(start);
//        dict.add(end);
//        for (String word : dict) {
//            Set<String> set = map.get(word);
//            if (set == null) {
//                set = new HashSet<String>();
//                map.put(word, set);
//            }
//
//            StringBuilder sb = new StringBuilder(word);
//            for (int i = 0; i < word.length(); i++) {
//                char c = word.charAt(i);
//                for (int j = 0; j < 26; j++) {
//                    if (j + 'a' == c) {
//                        continue;
//                    }
//                    sb.setCharAt(i, (char) (j + 'a'));
//                    String t = sb.toString();
//                    if (dict.contains(t)) {
//                        set.add(t);
//                    }
//                }
//                sb.setCharAt(i, c);
//            }
//        }
//    }
}
