package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by liwentian on 2017/8/31.
 */

/**
 * 如果要考虑到空间消耗，则要另外定义一个List<String>，每次新来一条日志，都要遍历
 * list中10s外的poll了，同时从map中remove
 *
 */
public class LoggerRateLimiter {

    private HashMap<String, Integer> mMap;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        mMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = mMap.getOrDefault(message, -100);
        if (timestamp - time >= 10) {
            mMap.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
