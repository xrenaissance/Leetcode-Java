package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class ValidPalindrome {

    // 耗时10ms
    public boolean isPalindrome(String s) {
        char[] ss = s.toLowerCase().toCharArray();
        for (int i = 0, j = ss.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(ss[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(ss[j])) {
                j--;
            } else {
                if (ss[i] != ss[j]) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
