package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/2.
 */

/**
 * https://leetcode.com/articles/binary-tree-longest-consecutive-sequence/
 */
public class BinaryTreeLongestConsecutiveSequence {

    private int longest;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutive(root, 0, root.val);
        return longest;
    }

    public void longestConsecutive(TreeNode root, int length, int target) {
        if (root == null) {
            return;
        } else if (root.val == target) {
            length++;
        } else {
            length = 1;
        }
        longest = Math.max(longest, length);
        longestConsecutive(root.left, length, root.val + 1);
        longestConsecutive(root.right, length, root.val + 1);
    }

    /** 这种写法很直观，不过不够简洁
    private int longest = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutive(root, 1);
        return longest;
    }

    public void longestConsecutive(TreeNode root, int length) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                longest = Math.max(longest, length + 1);
                longestConsecutive(root.left, length + 1);
            } else {
                longestConsecutive(root.left, 1);
            }
        }

        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                longest = Math.max(longest, length + 1);
                longestConsecutive(root.right, length + 1);
            } else {
                longestConsecutive(root.right, 1);
            }
        }
    }*/
}
