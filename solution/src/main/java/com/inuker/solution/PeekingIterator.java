package com.inuker.solution;

import java.util.Iterator;

/**
 * Created by dingjikerbo on 16/12/10.
 */

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> mIterator;

    private Integer mPeek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        mIterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (mPeek == null) {
            if (mIterator.hasNext()) {
                mPeek = mIterator.next();
            }
        }
        return mPeek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (mPeek == null) {
            if (mIterator.hasNext()) {
                mPeek = mIterator.next();
            }
        }
        Integer res = mPeek;
        mPeek = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return mPeek != null || mIterator.hasNext();
    }
}
