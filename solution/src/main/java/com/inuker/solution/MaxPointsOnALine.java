package com.inuker.solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import sun.nio.cs.ext.MacThai;

/**
 * Created by dingjikerbo on 16/12/7.
 */
/**
 * TestCase
 * 边界条件很多，比如有重复的点，有斜率无穷大的线
 * [[3,10],[0,2],[0,2],[3,10]] result = 4
 */
public class MaxPointsOnALine {

    private HashMap<Integer, HashMap<Integer, Set<Integer>>> mSames = new HashMap<>();

    private int mMaxCount;

    /**
     * 给相同的点合并在一起
     * @param points
     */
    public void initSames(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            HashMap map = mSames.get(point.x);
            if (map == null) {
                map = new HashMap();
                mSames.put(point.x, map);
            }
            Set set = (Set) map.get(point.y);
            if (set == null) {
                set = new HashSet<Integer>();
                map.put(point.y, set);
            }
            set.add(i);
            mMaxCount = Math.max(mMaxCount, set.size());
        }
    }

    /**
     * 返回该点相同的点
     */
    private Set<Integer> getSamePoint(Point point) {
        HashMap map = mSames.get(point.x);
        if (map == null) {
            return Collections.EMPTY_SET;
        }
        return (Set<Integer>) map.get(point.y);
    }

    public int maxPoints(Point[] points) {
        if (points.length == 0) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }

        initSames(points);

        HashMap<Double, HashMap<Double, Set<Integer>>> map = new HashMap<>();

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Set<Integer> set = null;

                int deltaX = points[i].x - points[j].x;
                int deltaY = points[i].y - points[j].y;

                // y = ax + b
                double a = 0, b = 0;

                // 相同的点不处理
                if (deltaX == 0 && deltaY == 0) {
                    continue;
                }

                // 斜率无穷大，这里用了个小技巧
                if (deltaX == 0) {
                    a = Double.MAX_VALUE;
                    b = points[i].x;
                } else {
                    a = 1.0f * deltaY / deltaX;
                    b = points[i].y - a * points[i].x;
                }

                HashMap<Double, Set<Integer>> subMap = map.get(a);
                if (subMap == null) {
                    subMap = new HashMap<Double, Set<Integer>>();
                    map.put(a, subMap);
                }
                set = subMap.get(b);
                if (set == null) {
                    set = new HashSet<Integer>();
                    subMap.put(b, set);
                }

                set.addAll(getSamePoint(points[i]));
                set.addAll(getSamePoint(points[j]));
                mMaxCount = Math.max(mMaxCount, set.size());
            }
        }

        return mMaxCount;
    }
}
