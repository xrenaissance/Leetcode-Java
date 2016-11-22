package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long nn = n;
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }
        double y = myPow(x, (int) (nn / 2));

        if (nn % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
