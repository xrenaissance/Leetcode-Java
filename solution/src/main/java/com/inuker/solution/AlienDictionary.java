package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 16/12/17.
 */

/**
 * 这道题需要进一步研究
 */

/**
 * TestCases
 * "z", "z" => "z"
 * "za", "zb", "ca", "cb" => "zacb"
 */

/**
 * 这题有几个地方容易错，
 * 1. 开头要初始化所有出现过的字符的degree为0，且要记下这些字符数count
 * 2. 结尾的时候要对比生成的字典长度是否和count相等，如果不等说明有环，返回空
 * 3. 在对比两个单词时，当first从开头包含second时，是不符合顺序的，如"abc"和"ab"，直接返回空
 * 4. 在设置degreee时要避免重复添加，比如'a'->'b'出现了多次，degree只能加1次
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] != 0) {
                    degree[c - 'a'] = 0;
                    count++;
                }
            }
        }
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    Set<Character> set = map.get(first.charAt(j));
                    if (set == null) {
                        set = new HashSet<Character>();
                        map.put(first.charAt(j), set);
                    }
                    if (set.add(second.charAt(j))) {
                        degree[second.charAt(j) - 'a']++;
                    }
                    break;
                } else {
                    if (j + 1 >= second.length() && j + 1 < first.length()) {
                        return "";
                    }
                }
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add((char) ('a' + i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character from = queue.poll();
            sb.append(from);
            Set<Character> set = map.get(from);
            if (set != null) {
                for (Character to: map.get(from)) {
                    if (--degree[to - 'a'] == 0) {
                        queue.add(to);
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
