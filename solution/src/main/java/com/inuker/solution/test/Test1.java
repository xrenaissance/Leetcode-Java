package com.inuker.solution.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length(), tl = t.length();
        if (sl < tl) {
            return isOneEditDistance(t, s);
        }
        if (sl - tl > 1) {
            return false;
        }
        for (int i = 0; i < tl; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return sl == tl ? s.substring(i + 1).equals(t.substring(i + 1))
                        : s.substring(i + 1).equals(t.substring(i));
            }
        }
        return sl != tl;
    }

    boolean knows(int a, int b) {
        return false;
    }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    int read4(char[] buf) {
        return 0;
    }

    private static final String[] LESS20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] LESS100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] THOUSAND = {
            "", "Thousand", "Million", "Billion"
    };

}
