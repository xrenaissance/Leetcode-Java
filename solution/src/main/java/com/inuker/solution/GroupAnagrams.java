package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] ss = str.toCharArray();
            Arrays.sort(ss);
            String s = new String(ss);

            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new LinkedList<String>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new LinkedList<List<String>>(map.values());
    }

}
