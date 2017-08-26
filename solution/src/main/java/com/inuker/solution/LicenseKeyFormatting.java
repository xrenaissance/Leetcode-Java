package com.inuker.solution;

/**
 * Created by liwentian on 17/8/26.
 */

/**
 * 将字符串s按长度k为一组，从右往左重排，组之间用"-"分隔，还要转成大写
 * 注意别在最前面多加一个"-"，即下面判断i != 0
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        String T = S.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = T.length() - 1, j = 0; i >= 0; i--) {
            sb.insert(0, T.charAt(i));
            if (++j == K && i != 0) {
                sb.insert(0, "-");
                j = 0;
            }
        }
        return sb.toString();
    }
}
