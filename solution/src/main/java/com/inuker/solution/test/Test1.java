package com.inuker.solution.test;

import com.inuker.solution.PalindromeLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

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
}
