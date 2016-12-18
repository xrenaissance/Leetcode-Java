package com.inuker.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/12/12.
 */

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<String>();

        int count = 0, last = 0;
        for (int first = 0; first < words.length; first = last) {
            for (last = first, count = 0; last < words.length; last++) {
                if (count + words[last].length() + last - first > maxWidth) {
                    break;
                }
                count += words[last].length();
            }
            StringBuilder sb = new StringBuilder();
            if (last == words.length || last - first == 1) {
                for (int i = first; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for ( ; sb.length() < maxWidth; sb.append(" "));
            } else {
                int spaces = maxWidth - count;
                int avg = spaces / (last - first - 1);
                int extraSpaces = spaces - avg * (last - first - 1);
                for (int i = first; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        int curSpaces = avg + (extraSpaces > 0 ? 1 : 0);
                        for (int j = 0; j < curSpaces; j++) {
                            sb.append(" ");
                        }
                        extraSpaces--;
                    }
                }
            }

            result.add(sb.toString());
        }

        return result;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        List<String> list = new LinkedList<String>();
        if (root != null) {
            list.add(root.val + "");
            helper(root, list, result);
        }
        return result;
    }

    private void helper(TreeNode node, List<String> list, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(String.join("->", list));
            return;
        }
        if (node.left != null) {
            list.add(node.left.val + "");
            helper(node.left, list, result);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            list.add(node.right.val + "");
            helper(node.right, list, result);
            list.remove(list.size() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {
        return null;
    }

    public String minWindow(String s, String t) {
        int CHAR_MAX = 256;
        int[] ss = new int[CHAR_MAX];
        int[] tt = new int[CHAR_MAX];
        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i)]++;
        }
        int count = 0, min = Integer.MAX_VALUE, start = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (++ss[s.charAt(j)] <= tt[s.charAt(j)]) {
                ++count;
            }
            if (count >= t.length()) {
                for ( ; i < j; i++) {
                    char c = s.charAt(i);
                    if (tt[c] > 0 && ss[c] <= tt[c]) {
                        break;
                    }
                    ss[c]--;
                }
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        for (ListNode node = dummy; !queue.isEmpty(); node = node.next) {
            ListNode next = queue.poll();
            if (next.next != null) {
                queue.add(next.next);
            }
            node.next = next;
        }
        return dummy.next;
    }

    private int[] mRoots;
    private int mCount;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        mRoots = new int[m * n];
        Arrays.fill(mRoots, -1);

        List<Integer> list = new LinkedList<Integer>();
        for (int[] position : positions) {
            int x = position[0], y = position[1];
            int z = x * n + y;

            mRoots[z] = z;
            mCount++;

            if (x > 0 && mRoots[z - n] != -1) {
                union(z, z - n);
            }

            if (x < m - 1 && mRoots[z + n] != -1) {
                union(z, z + n);
            }

            if (y > 0 && mRoots[z - 1] != -1) {
                union(z, z - 1);
            }

            if (y < n - 1 && mRoots[z + 1] != -1) {
                union(z, z + 1);
            }

            list.add(mCount);
        }
        return list;
    }

    private void union(int i, int j) {
        int i0 = find(i);
        int j0 = find(j);
        if (i0 != j0) {
            mRoots[i0] = j0;
            mCount--;
        }
    }

    private int find(int i) {
        while (mRoots[i] != i) {
            i = mRoots[i];
        }
        return i;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'x';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            if (x > 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = 'x';
                queue.add(new int[] {x - 1, y});
            }

            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                grid[x + 1][y] = 'x';
                queue.add(new int[] {x + 1, y});
            }

            if (y > 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = 'x';
                queue.add(new int[] {x, y - 1});
            }

            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                grid[x][y + 1] = 'x';
                queue.add(new int[] {x, y + 1});
            }
        }
    }

    public boolean isOneEditDistance(String s, String t) {
        int sL = s.length(), tL = t.length();
        if (Math.abs(sL - tL) > 1) {
            return false;
        }
        if (sL > tL) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < sL; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sL < tL) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }
        return sL != tL;
    }

    private static final String SEP = ",";
    private static final String NULL = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            sb.append(root != null ? root.val : NULL).append(SEP);

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] texts = data.split(SEP);
        Queue<String> queue = new LinkedList<String>(Arrays.asList(texts));
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = getNode(queue), node = root;

        while (!queue.isEmpty()) {
            if (node == null) {
                node = stack.pop();
                node.right = getNode(queue);
                node = node.right;
            } else {
                stack.push(node);
                node.left = getNode(queue);
                node = node.left;
            }
        }

        return root;
    }

    private TreeNode getNode(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String text = queue.poll();
        if (text.equals(NULL)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(text));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new LinkedList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = null, prev = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev == p) {
                    return node;
                }
                prev = node;
                node = node.right;
            }
        }
        return null;
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }

    boolean knows(int a, int b) {
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (j++, k-- ; j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]; j++, k--);
                }
            }
        }
        return result;
    }

    private char[] mTmp = new char[4];
    private int mIndex = 0, mSize = 0;

    public int read(char[] buf, int n) {
        int i = 0;
        for (; i < n; ) {
            if (mIndex < mSize) {
                buf[i++] = mTmp[mIndex++];
            } else {
                mIndex = 0;
                mSize = read4(mTmp);
                if (mSize <= 0) {
                    break;
                }
            }
        }
        return i;
    }

    public int read2(char[] buf, int n) {
        int i = 0;
        char[] tmp = new char[4];
        for (; i < n; ) {
            int size = read4(tmp);
            for (int j = 0; j < size && i < n; ) {
                buf[i++] = tmp[j++];
            }
            if (size < 4) {
                break;
            }
        }
        return i;
    }

    int read4(char[] buf) {
        return 0;
    }

    public boolean isMatch(String s, String p) {
        int s0 = -1, p0 = -1, j = 0;
        for (int i = 0; i < s.length(); ) {
            if (j < p.length()) {
                if (p.charAt(j) == '*') {
                    s0 = i;
                    p0 = j++;
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else if (s0 != -1) {
                    i = s0++;
                    j = p0 + 1;
                } else {
                    return false;
                }
            } else if (s0 != -1) {
                i = s0++;
                j = p0 + 1;
            } else {
                return false;
            }
        }
        for (; j < p.length() && p.charAt(j) == '*'; j++) ;
        return j >= p.length();
    }

    public boolean isMatch2(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            return s.length() == 1 && isEquals(s, p);
        }

        if (p.charAt(1) != '*') {
            return s.length() > 0 && isEquals(s, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() > 0) {
                if (isEquals(s, p)) {
                    return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
                } else {
                    return isMatch(s, p.substring(2));
                }
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    private boolean isEquals(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return helper(s, 0, new int[s.length()]);
    }

    private int helper(String s, int start, int[] f) {
        if (start >= s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        if (f[start] > 0) {
            return f[start];
        }
        int num = 0;
        if (start + 1 < s.length()) {
            if (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) <= '6')) {
                num += helper(s, start + 2, f);
            }
        }
        f[start] = num + helper(s, start + 1, f);
        return f[start];
    }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // 耗时3ms
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if (digits.length() == 0) {
            return result;
        }
        helper(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(String digits, int k, StringBuilder sb, List<String> result) {
        if (k == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int n = digits.charAt(k) - '0';
        for (int i = 0; i < ARR[n].length(); i++) {
            sb.append(ARR[n].charAt(i));
            helper(digits, k + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            if (newInterval.start > interval.end) {
                result.add(interval);
            } else if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        result.add(newInterval);
        return result;
    }

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
        for (; i >= 0 || j >= 0 || k > 0; i--, j--) {
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
        for (; rows > 0; rows--) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                for (; start >= 0 && s.charAt((start - 1) % len) != ' '; start--) ;
            }
        }
        return start / len;
    }

}
