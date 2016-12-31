package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class LongestConsecutiveSequence {

    /**
     * map中保存的是某个点所在的联通块长度，不过要注意的这个连通块两端的点才是准的，中间的点可能不准
     * 所以我们每次新插入一个点时，一定要更新连通块两端的点
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int len = left + right + 1;

                // 这句一定不能掉，因为map会查重的，如果这里n没丢到map里，后面再出现重复的n会被覆盖
                map.put(n, len);

                res = Math.max(res, len);

                map.put(n - left, len);
                map.put(n + right, len);
            }
        }

        return res;
    }
}
