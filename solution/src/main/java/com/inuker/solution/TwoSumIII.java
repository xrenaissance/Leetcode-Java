package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by liwentian on 2016/12/15.
 */

public class TwoSumIII {

    private HashMap<Integer, Integer> mMap = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    public void add(int number) {
        mMap.put(number, mMap.getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Integer n : mMap.keySet()) {
            int m = value - n;
            if (m != n && mMap.containsKey(m)) {
                return true;
            }
            if (m == n && mMap.get(m) > 1) {
                return true;
            }
        }
        return false;
    }
}
