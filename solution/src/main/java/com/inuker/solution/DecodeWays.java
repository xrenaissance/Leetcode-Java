package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/20.
 */

import java.util.Arrays;

/**
 * TestCases
 * "7893749912342187894921836847319981199844151766195952528631828655978178193192959793156142441128167383"
 */
public class DecodeWays {
    /** 思路一
    // 超时了，有大量的字符串复制，不过思路挺直观的
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return helper(s);
    }

    public int helper(String s) {
        // 如果能一直正确匹配到结尾了是合法的
        if (s.length() == 0) {
            return 1;
        }

        // 以0开头的是非法的
        if (s.charAt(0) == '0') {
            return 0;
        }

        int ways = 0;

        if (s.length() > 1 && (s.charAt(0) == '1' || (s.charAt(0) == '2' && (s.charAt(1) >= '0' && s.charAt(1) <= '6')))) {
            ways += helper(s.substring(2));
        }

        ways += helper(s.substring(1));

        return ways;
    }
*/

    /** 思路二
    // 这里进行了优化，去掉了字符串复制，但有些cases仍然超时，因为仍然有大量重复运算
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return helper(s.toCharArray(), 0);
    }

    public int helper(char[] s, int i) {
        if (i >= s.length) {
            return 1;
        }

        if (s[i] == '0') {
            return 0;
        }

        int ways = 0;

        if (i < s.length - 1 && (s[i] == '1' || (s[i] == '2' && (s[i + 1] >= '0' && s[i + 1] <= '6')))) {
            ways += helper(s, i + 2);
        }

        ways += helper(s, i + 1);
        return ways;
    }
*/

    /**
     * 思路三
    // 这里继续优化，为避免重复运算，对结果进行了缓存，性能非常好
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] f = new int[s.length()];
        Arrays.fill(f, -1);
        return helper(s.toCharArray(), f, 0);
    }

    public int helper(char[] s, int[] f, int i) {
        if (i >= s.length) {
            return 1;
        }

        if (s[i] == '0') {
            f[i] = 0;
            return 0;
        }

        if (f[i] >= 0) {
            return f[i];
        }

        int ways = 0;

        if (i < s.length - 1 && (s[i] == '1' || (s[i] == '2' && (s[i + 1] >= '0' && s[i + 1] <= '6')))) {
            ways += helper(s, f, i + 2);
        }

        ways += helper(s, f, i + 1);

        f[i] = ways;

        return ways;
    }
*/

    // DP，耗时2ms，复杂度O(n)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        int[] f = new int[len + 1];

        f[0] = 1;
        f[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                f[i] = f[i - 2];
            }

            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
        }

        return f[len];
    }
}
