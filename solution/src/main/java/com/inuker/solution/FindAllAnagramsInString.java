package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class FindAllAnagramsInString {

    // 耗时24ms
    public List<Integer> findAnagrams(String s, String p) {
        int[] pcounts = new int[26];

        int slen = s.length(), plen = p.length();

        for (int i = 0; i < plen; i++) {
            pcounts[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new LinkedList<Integer>();

        int[] scounts = new int[26];
        for (int i = 0; i < slen; i++) {
            scounts[s.charAt(i) - 'a']++;
            if (i >= plen) {
                scounts[s.charAt(i - plen) - 'a']--;
            }
            if (i >= plen - 1 && Arrays.equals(scounts, pcounts)) {
                result.add(i - plen + 1);
            }
        }

        return result;
    }
}
