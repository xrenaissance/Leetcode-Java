package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/12/10.
 */

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] f = new boolean[n];
        Arrays.fill(f, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (f[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    f[i * j] = false;
                }
            }
        }
        return count;
    }
}
