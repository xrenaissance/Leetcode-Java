package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int res = result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = res % 10;
                result[i + j] += res / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            // 这里要去掉头部的"0"
            if (n == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(n);
        }

        /**
         * 这里要注意如果是空要返回0
         */
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
