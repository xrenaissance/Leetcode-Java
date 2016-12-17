package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/17.
 */

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int len = s.length();

        int sum = 0, t = 1;

        for (int i = len - 1; i >= 0; i--) {
            int n = s.charAt(i) - 'A' + 1;
            sum += n * t;
            t *= 26;
        }

        return sum;
    }
}
