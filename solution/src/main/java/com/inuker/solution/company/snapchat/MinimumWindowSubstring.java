package com.inuker.solution.snapchat;

/**
 * Created by liwentian on 17/8/15.
 */

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] sc = new int[256], tc = new int[256];

        for (char c : t.toCharArray()) {
            tc[c]++;
        }

        int minStart = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0, j = 0, k = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (++sc[c] <= tc[c]) {
                ++k;
            }

            if (k == t.length()) {
                for (; i < j; i++) {
                    char cc = s.charAt(i);

                    if (tc[cc] == 0) {
                        continue;
                    }

                    if (sc[cc] <= tc[cc]) {
                        break;
                    }

                    sc[cc]--;
                }

                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    minStart = i;
                }
            }
        }

        return minLen != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLen) : "";
    }//ADOBECODEBANC
}
