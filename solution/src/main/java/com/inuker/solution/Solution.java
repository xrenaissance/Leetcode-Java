package com.inuker.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/12/12.
 */

public class Solution {

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
        if (prev != null) {
            result.add(prev);
        }
        return result;
    }

    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Queue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int size = 0;
        for (Interval interval : intervals) {
            if (!queue.isEmpty() && queue.peek().end <= interval.start) {
                queue.poll();
            }
            queue.add(interval);
            size = Math.max(size, queue.size());
        }
        return size;
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    private boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + ((j - i) >>> 1);
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    private final String[] LESS_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] LESS_100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] THOUSANDS = {
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int count = 0; num > 0; num /= 1000, count++) {
            int s = num % 1000;
            if (s > 0) {
                sb.insert(0, String.format(" %s %s", helper(s), THOUSANDS[count]));
            }
        }
        return sb.toString().trim();
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(String.format("%s Hundred", LESS_20[num / 100]));
        }
        num %= 100;
        if (num < 20) {
            sb.append(" " + LESS_20[num]);
        } else {
            sb.append(String.format(" %s %s", LESS_100[num / 10], LESS_20[num % 10]));
        }
        return sb.toString().trim();
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, k = 0;
        for ( ; i >= 0 || j >= 0 || k > 0; i--, j--) {
            int i0 = i >= 0 ? a.charAt(i) - '0' : 0;
            int j0 = j >= 0 ? b.charAt(j) - '0' : 0;
            int s = i0 + j0 + k;
            sb.insert(0, s & 1);
            k = s >> 1;
        }
        return sb.toString();
    }

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
