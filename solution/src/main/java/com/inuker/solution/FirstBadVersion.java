package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public abstract class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + ((right - left) >>> 1);

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    abstract boolean isBadVersion(int version);
}
