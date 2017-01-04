package com.inuker.solution;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/11/22.
 */

public abstract class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> mStack;

    public NestedIterator(List<NestedInteger> nestedList) {
        mStack = new Stack<NestedInteger>();
        pushNestedList(nestedList);
    }

    /**
     * 容易错的地方是NestedInteger有可能是list，而list中没有实在的数据，
     * 而是若干层套在一起的空，所以hasNext不能只判断栈是否为空
     */
    @Override
    public boolean hasNext() {
        while (!mStack.isEmpty()) {
            NestedInteger nest = mStack.peek();
            if (nest.isInteger()) {
                return true;
            } else {
                nest = mStack.pop();
                pushNestedList(nest.getList());
            }
        }
        return false;
    }

    private void pushNestedList(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            mStack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger nest = mStack.pop();
        return nest.getInteger();
    }
}
