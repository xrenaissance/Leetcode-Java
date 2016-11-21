package com.inuker.solution;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/21.
 */

public class MergeIntervals {

    // 耗时26ms，时间复杂度O(nlgn)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();

        if (intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start > o2.start ? 1 : - 1;
            }
        });

        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if (i > 0 && cur.start > end) {
                result.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            } else {
                start = Math.min(start, cur.start);
                end = Math.max(end, cur.end);
            }
        }

        result.add(new Interval(start, end));

        return result;
    }
}
