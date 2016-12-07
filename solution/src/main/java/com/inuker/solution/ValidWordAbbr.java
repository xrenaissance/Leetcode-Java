package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dingjikerbo on 16/12/4.
 */

/**
 * 这道题还挺容易错
 * 参考https://leetcode.com/articles/unique-word-abbreviation/
 */
public class ValidWordAbbr {
/** 这题容易错的地方是unique的理解，即dic中不存在该word，要排除word
 *  // 耗时100ms
    private HashMap<String, Set<String>> mMap;

    public ValidWordAbbr(String[] dictionary) {
        mMap = new HashMap<String, Set<String>>();
        for (String text : dictionary) {
            String abbr = getAbbr(text);

            Set<String> set = mMap.get(abbr);
            if (set == null) {
                set = new HashSet<String>();
                mMap.put(abbr, set);
            }
            set.add(text);
        }
    }

    public boolean isUnique(String word) {
        Set<String> set = mMap.get(getAbbr(word));
        return set == null || (set.size() == 1 && set.contains(word));
    }

    private String getAbbr(String word) {
        int len = word.length();
        if (len == 0) {
            return "";
        }
        return word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1);
    }*/

    private HashMap<String, Integer> mMap;
    private Set<String> mSet;

    // 耗时69ms，比上面的快一点
    public ValidWordAbbr(String[] dictionary) {
        mMap = new HashMap<String, Integer>();
        mSet = new HashSet<String>();
        for (String text : dictionary) {
            String abbr = getAbbr(text);

            if (mSet.add(text)) {
                mMap.put(abbr, mMap.containsKey(abbr) ? mMap.get(abbr) + 1 : 1);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !mMap.containsKey(abbr) || (mMap.get(abbr) == 1 && mSet.contains(word));
    }

    private String getAbbr(String word) {
        int len = word.length();
        if (len == 0) {
            return "";
        }
        return word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1);
    }
}
