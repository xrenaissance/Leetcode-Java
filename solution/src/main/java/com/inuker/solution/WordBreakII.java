package com.inuker.solution;

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

    /**
     * 下面这种写法可以AC，不过当wordDict很大时则效率堪忧
     */
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

    /**
     * 这种写法耗时16ms，效率不错
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        return dfs2(s, wordDict, new HashMap<String,List<String>>());
    }

    public List<String> dfs2(String s, List<String> wordDict, HashMap<String,List<String>> map) {
        List<String> result = new LinkedList<>();
        if (s.length() == 0) {
            /**
             * 注意这里要加一个""，不能返回空链表
             */
            return new LinkedList<>(Arrays.asList(""));
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i <= s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> list = dfs2(s.substring(0, i), wordDict, map);
                for (String ss : list) {
                    result.add((ss.length() > 0 ? ss + " " : "") + t);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
