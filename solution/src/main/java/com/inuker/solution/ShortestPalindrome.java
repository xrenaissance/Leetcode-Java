package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

/**
 * https://segmentfault.com/a/1190000003059361
 */
public class ShortestPalindrome {
    /**
     * 其实只要将s与s的逆序串拼接在一起，求最长公共子串，逆序串中刨除这个最长公共子串，就是要加到s前面的
     */
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

    /**
     * 更直观的写法
     */
    private int getCommonLength2(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return getCommonLength(str + rev, str.length());
    }

    private int getCommonLength(String s, int max) {
        for (int i = s.length() - max; i < s.length(); i++) {
            if (s.startsWith(s.substring(i))) {
                return s.length() - i;
            }
        }
        return 0;
    }
}
