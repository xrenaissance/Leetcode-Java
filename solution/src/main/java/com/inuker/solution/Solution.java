package com.inuker.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/12/12.
 */

public class Solution {

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B[0].length; j++) {
                        result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return result;

//        int[][] result = new int[A.length][B[0].length];
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B[0].length; j++) {
//                for (int k = 0; k < A[0].length; k++) {
//                    result[i][j] += A[i][k] * B[k][j];
//                }
//            }
//        }
//        return result;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        map.put(root, 0);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int index = map.get(node);
            min = Math.min(min, index);
            max = Math.max(max, index);

            List<Integer> list = map2.get(index);
            if (list == null) {
                list = new LinkedList<Integer>();
                map2.put(index, list);
            }
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, index - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, index + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map2.get(i));
        }
        return result;
    }

    public List<String> removeInvalidParentheses(String s) {
        int nl = 0, nr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                nl++;
            } else if (s.charAt(i) == ')') {
                if (nl > 0) {
                    nl--;
                } else {
                    nr++;
                }
            }
        }
        HashSet<String> set = new HashSet<String>();
        dfs(s, 0, set, new StringBuilder(), nl, nr, 0);
        return new LinkedList<String>(set);
    }

    private void dfs(String s, int i, HashSet<String> set, StringBuilder sb, int nl, int nr, int count) {
        if (nl < 0 || nr < 0 || count < 0) {
            return;
        }
        if (i == s.length()) {
            if (nl == 0 && nr == 0 && count == 0) {
                set.add(sb.toString());
            }
            return;
        }
        int len = sb.length();
        if (s.charAt(i) == '(') {
            dfs(s, i + 1, set, sb, nl - 1, nr, count);
            dfs(s, i + 1, set, sb.append('('), nl, nr, count + 1);
        } else if (s.charAt(i) == ')') {
            dfs(s, i + 1, set, sb, nl, nr - 1, count);
            dfs(s, i + 1, set, sb.append(')'), nl, nr, count - 1);
        } else {
            dfs(s, i + 1, set, sb.append(s.charAt(i)), nl, nr, count);
        }
        sb.setLength(len);
    }

    public List<String> removeInvalidParentheses2(String s) {
        Queue<String> queue = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        List<String> result = new LinkedList<String>();

        queue.add(s);
        while (!queue.isEmpty()) {
            String ss = queue.poll();
            if (isValidParentheses(ss)) {
                result.add(ss);
            } else {
                for (int i = 0; i < ss.length(); i++) {
                    if (ss.charAt(i) != '(' && ss.charAt(i) != ')') {
                        continue;
                    }
                    String st = ss.substring(0, i) + ss.substring(i + 1);
                    if (visited.add(st)) {
                        next.add(st);
                    }
                }
            }

            if (queue.isEmpty() && result.isEmpty()) {
                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }

    private boolean isValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                if (--count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i > 0 ? nums[i - 1] : 0;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer p = map.get(nums[i] - k);
            if (p != null) {
                maxLen = Math.max(maxLen, i - p);
            }
        }
        return maxLen;
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; j++) {
            if (j < nums.length) {
                if (nums[j] != 0) {
                    nums[i++] = nums[j];
                }
            } else {
                nums[i++] = 0;
            }
        }
    }

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
