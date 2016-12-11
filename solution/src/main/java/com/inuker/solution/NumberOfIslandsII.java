package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

/**
 * 经典的UF(Union Find)问题，可翻阅《算法》1.5章
 * UF时间复杂度和节点个数有关
 */
public class NumberOfIslandsII {

    private int[] mRoots;
    private int mCount;

    // 时间复杂度klgmn
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new LinkedList<Integer>();

        mRoots = new int[m * n];
        Arrays.fill(mRoots, -1);

        for (int[] p : positions) {
            int i = p[0], j = p[1];
            int root = i * n + j;
            mRoots[root] = root;
            mCount++;

            if (i > 0 && mRoots[root - n] != -1) {
                union(root, root - n);
            }

            if (i + 1 < m && mRoots[root + n] != -1) {
                union(root, root + n);
            }

            if (j > 0 && mRoots[root - 1] != -1) {
                union(root, root - 1);
            }

            if (j + 1 < n && mRoots[root + 1] != -1) {
                union(root, root + 1);
            }

            list.add(mCount);
        }

        return list;
    }

    private void union(int p, int q) {
        int proot = findIsLand(p);
        int qroot = findIsLand(q);
        if (proot != qroot) {
            mRoots[proot] = qroot;
            mCount--;
        }
    }

    private int findIsLand(int root) {
        while (root != mRoots[root]) {
            root = mRoots[root];
        }
        return root;
    }
}
