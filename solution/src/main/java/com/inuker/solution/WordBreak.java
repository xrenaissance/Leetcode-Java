package com.inuker.solution;

import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * https://leetcode.com/articles/word-break/
 */
public class WordBreak {

    // 耗时12ms
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[len];
    }
}
