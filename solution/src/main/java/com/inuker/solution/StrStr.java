package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class StrStr {

    // 这里非常重要的是i<=len1-len2，如果没有这个会超时
    int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int l1 = s.length, l2 = t.length;
        for (int i = 0, j = 0; i <= l1 - l2; i++) {
            for (j = 0; j < l2 && s[i + j] == t[j]; j++);
            if (j == l2) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
