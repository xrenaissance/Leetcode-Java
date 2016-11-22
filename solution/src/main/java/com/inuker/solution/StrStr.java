package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class StrStr {

    // 这种暴力法会超时，需要用KMP
    int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i < len1; i++) {
            int j = 0;
            for ( ; i + j < len1 && j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == len2) {
                return i;
            }
        }
        return -1;
    }

}
