package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/21.
 */

public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }
}
