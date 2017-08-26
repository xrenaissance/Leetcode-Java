package com.leetcode.topics.interval;

import com.leetcode.library.Interval;

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
                return o1.start - o2.start;
            }
        });
        Interval prev = null;
        for (Interval interval : intervals) {
            if (prev == null) {
                prev = interval;
            } else {
                if (interval.start > prev.end) {
                    result.add(prev);
                    prev = interval;
                } else {
                    prev.end = Math.max(prev.end, interval.end);
                }
            }
        }
        result.add(prev);
        return result;
    }
}
