package com.inuker.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.type.MirroredTypeException;

/**
 * Created by dingjikerbo on 16/12/10.
 */

public class ZigzagIterator {

    private List<Iterator> mIterators;
    private int mCurIndex;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        mIterators = new ArrayList<Iterator>();
        if (v1.iterator().hasNext()) {
            mIterators.add(v1.iterator());
        }
        if (v2.iterator().hasNext()) {
            mIterators.add(v2.iterator());
        }
    }

    public int next() {
        Iterator itor = mIterators.get(mCurIndex);
        int value = (int) itor.next();
        if (!itor.hasNext()) {
            mIterators.remove(mCurIndex);
        } else {
            mCurIndex++;
        }
        if (!mIterators.isEmpty()) {
            mCurIndex %= mIterators.size();
        }
        return value;
    }

    public boolean hasNext() {
        return !mIterators.isEmpty();
    }
}
