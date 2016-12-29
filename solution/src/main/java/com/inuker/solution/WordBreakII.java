package com.inuker.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * 这题是个典型的DFS，不过为了加速用了缓存避免重复计算
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (s.length() == 0) {
            return Arrays.asList("");
        }

        List<String> result = map.get(s);

        if (result != null) {
            return result;
        } else {
            result = new LinkedList<String>();
            map.put(s, result);
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = dfs(s.substring(word.length()), wordDict, map);
                for (String text : list) {
                    result.add(word + (text.length() > 0 ? " " + text : ""));
                }
            }
        }
        return result;
    }

    /** 这种方法比较直观，但是会超时
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<List<String>>[] f = new LinkedList[s.length() + 1];
        f[0] = new LinkedList<List<String>>();
        f[0].add(Collections.EMPTY_LIST);
        for (int i = 1; i <= s.length(); i++) {
            f[i] = new LinkedList<List<String>>();
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (wordDict.contains(word)) {
                    for (List<String> list : f[j]) {
                        List<String> list2 = new LinkedList<String>(list);
                        list2.add(word);
                        f[i].add(list2);
                    }
                }
            }
        }
        List<String> result = new LinkedList<String>();
        for (List<String> list : f[s.length()]) {
            result.add(String.join(" ", list));
        }
        return result;
    }*/

    /** 这种某些case下内存占用会超
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] f = new LinkedList[s.length() + 1];
        f[0] = new LinkedList<String>(Arrays.asList(""));
        for (int i = 1; i <= s.length(); i++) {
            f[i] = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (wordDict.contains(word)) {
                    for (String text : f[j]) {
                        f[i].add((text.length() > 0 ? text + " " : "") + word);
                    }
                }
            }
        }
        return f[s.length()];
    }*/

    /** 这样某些case也会超时
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("", new LinkedList<String>(Arrays.asList("")));
        for (int i = 1; i <= s.length(); i++) {
            String t = s.substring(0, i);

            List<String> list = map.get(t);
            if (list == null) {
                list = new LinkedList<String>();
                map.put(t, list);
            }

            for (int j = 0; j < i; j++) {
                String suffix = s.substring(0, j);
                String word = s.substring(j, i);
                if (map.containsKey(suffix) && wordDict.contains(word)) {
                    for (String text : map.get(suffix)) {
                        list.add((text.length() > 0 ? text + " " : "") + word);
                    }
                }
            }
        }
        return map.get(s);
    }*/
}
