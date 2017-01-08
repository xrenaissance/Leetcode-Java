package com.inuker.solution.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() > k) {
                for ( ; j < i; ) {
                    char c1 = s.charAt(j++);
                    map.put(c1, map.get(c1) - 1);
                    if (map.get(c1) == 0) {
                        map.remove(c1);
                        break;
                    }
                }
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
