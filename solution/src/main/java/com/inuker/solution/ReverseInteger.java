package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/10.
 */

public class ReverseInteger {

    // 耗时43ms
    public int reverse(int x) {
        long y = x;
        int sign = y > 0 ? 1 : -1;
        y = y > 0 ? y : -y;
        String s = String.valueOf(y);
        s = new StringBuilder(s).reverse().toString();
        y = Long.valueOf(s) * sign;
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) y;
    }

    // 耗时40ms
    public int reverse2(int x) {
        long y = x, r = 0;
        int sign = x > 0 ? 1 : -1;
        y = y > 0 ? y : -y;
        for ( ; y > 0; y /= 10) {
            r = r * 10 + y % 10;
        }
        r *= sign;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) r;
    }
}
