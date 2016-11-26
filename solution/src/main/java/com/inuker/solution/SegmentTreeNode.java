package com.inuker.solution;

/**
 * Created by liwentian on 2016/11/26.
 */

public class SegmentTreeNode {

    public SegmentTreeNode left, right;

    public int sum;

    public int start, end;

    SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
