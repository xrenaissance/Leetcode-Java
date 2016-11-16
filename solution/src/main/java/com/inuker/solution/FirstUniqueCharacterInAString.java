package com.inuker.solution;

/**
 * Created by liwentian on 2016/11/16.
 */

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        char[] counts = new char[256];
        char[] ss = s.toCharArray();
        for (char c : ss) {
            counts[c]++;
        }
        for (int i = 0; i < ss.length; i++) {
            if (counts[ss[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
