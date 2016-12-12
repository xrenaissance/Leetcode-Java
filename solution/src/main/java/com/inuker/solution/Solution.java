package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/12.
 */

public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long next = lower;
        List<String> list = new LinkedList<String>();
        for (int n : nums) {
            if (n < next) {
                continue;
            }

            if (n > next) {
                list.add(getRange(next, n - 1));
            }

            next = (long) n + 1;
        }

        if (upper >= next) {
            list.add(getRange(next, upper));
        }

        return list;
    }

    private String getRange(long low, int high) {
        return low == high ? String.valueOf(low) : low + "->" + high;
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int rowKill = 0, maxKill = 0;
        int[] colKill = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowKill = 0;
                    for (int k = j; k < col && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowKill++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colKill[j] = 0;
                    for (int k = i; k < row && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colKill[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    maxKill = Math.max(maxKill, rowKill + colKill[j]);
                }
            }
        }
        return maxKill;
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), start = 0;
        for ( ; rows > 0; rows--) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                for ( ; start >= 0 && s.charAt((start - 1) % len) != ' '; start--);
            }
        }
        return start / len;
    }

}
