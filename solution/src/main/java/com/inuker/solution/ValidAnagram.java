package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class ValidAnagram {

    // 耗时6ms，时间复杂度O(n)
    public boolean isAnagram(String s, String t) {
        int slen = s.length(), tlen = t.length();

        if (slen != tlen) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < slen; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // 耗时6ms，时间复杂度O(nlgn)
    public boolean isAnagram2(String s, String t) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        char[] tt = t.toCharArray();
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }
}
