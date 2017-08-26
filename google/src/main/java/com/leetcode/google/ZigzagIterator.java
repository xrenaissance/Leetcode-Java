package com.leetcode.google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liwentian on 17/8/26.
 */

public class ZigzagIterator {

    private List<List<Integer>> mLists = new ArrayList<>();
    private List<Iterator> mIterators = new ArrayList<>();

    private int mCurIdx;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        init(v1, v2);
    }

    private void init(List<Integer>... lists) {
        for (List<Integer> list : lists) {
            mLists.add(list);
            mIterators.add(list.iterator());
        }
    }

    public int next() {
        int value = (int) mIterators.get(mCurIdx).next();
        mCurIdx = (mCurIdx + 1) % mLists.size();
        return value;
    }

    public boolean hasNext() {
        if (mLists.isEmpty()) {
            return false;
        }

        Iterator iterator = mIterators.get(mCurIdx);

        if (iterator.hasNext()) {
            return true;
        }

        for (int i = mCurIdx + 1; i != mCurIdx; i = (i + 1) % mLists.size()) {
            if (mIterators.get(i).hasNext()) {
                mCurIdx = i;
                return true;
            }
        }

        return false;
    }
}
