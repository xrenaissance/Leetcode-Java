package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuffer sf = new StringBuffer();
        for ( ; n > 0; n /= 26) {
            int k = n % 26;
            if (k == 0) {
                n -= 26;
                sf.insert(0, 'Z');
            } else {
                n -= k;
                sf.insert(0, (char) ('A' + k - 1));
            }
        }
        return sf.toString();
    }
}
