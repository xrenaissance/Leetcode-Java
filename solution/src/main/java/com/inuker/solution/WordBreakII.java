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
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new LinkedList<String>();
        if (s.length() == 0) {
            return Arrays.asList("");
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = helper(s.substring(word.length()), wordDict, map);
                for (String ss : list) {
                    if (ss.length() > 0) {
                        result.add(word + " " + ss);
                    } else {
                        result.add(word);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
