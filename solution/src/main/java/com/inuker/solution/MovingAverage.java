package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/4.
 */

public class MovingAverage {

    private int mSize;

    private double mSum;
    private List<Integer> mList;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        mSize = size;
        mList = new LinkedList<Integer>();
    }

    public double next(int val) {
        mSum += val;

        mList.add(val);

        if (mList.size() > mSize) {
            int n = mList.remove(0);
            mSum -= n;
        }

        return mSum / mList.size();
    }
}
