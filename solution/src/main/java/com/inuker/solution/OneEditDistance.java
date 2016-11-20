package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class OneEditDistance {

    // 耗时1ms
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s);
        }

        if (s.length() - t.length() > 1) {
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            if (i >= tt.length || ss[i] != tt[i]) {
                if (ss.length == tt.length) {
                    return equals(ss, i + 1, tt, i + 1);
                } else {
                    return equals(ss, i + 1, tt, i);
                }
            }
        }

        return false;
    }

    private boolean equals(char[] s, int si, char[] t, int ti) {
        for ( ; si < s.length && ti < t.length && s[si] == t[ti]; si++, ti++);
        return si == s.length && ti == t.length;
    }
}
