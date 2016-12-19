package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int len = s.length();

        int maxLen = 1;

        for (int i = 0; i <= len / 2; i++) {
            int palen = 1;

            for (int j = 0; i - j >= 0 && i + j < len; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    palen = Math.max(palen, 2 * j + 1);
                } else {
                    break;
                }
            }

            for (int j = 0; i - j >= 0 && i + j + 1 < len; j++) {
                if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                    palen = Math.max(palen, 2 * j + 2);
                } else {
                    break;
                }
            }

            if (i - (palen - 1) / 2 == 0) {
                maxLen = palen;
            }
        }

        StringBuffer sb = new StringBuffer(s);
        for (int i = maxLen; i < len; i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }

    /**
    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        StringBuilder builder = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        builder.append("#").append(rev);
        int[] p = new int[builder.length()];
        for (int i = 1; i < p.length; i++) {
            int j = p[i - 1];
            while (j > 0 && builder.charAt(i) != builder.charAt(j)) j = p[j - 1];
            p[i] = j == 0 ? (builder.charAt(i) == builder.charAt(0) ? 1 : 0) : j + 1;
        }
        return p[p.length - 1];
    }
     */
}
