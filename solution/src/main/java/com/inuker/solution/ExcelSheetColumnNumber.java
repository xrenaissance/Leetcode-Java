package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0, t = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * t;
            t *= 26;
        }
        return res;
    }
}
