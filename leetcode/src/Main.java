import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int index, max = start;
            for (index = start + 1; index <= end; index++) {
                if (nums[index] > nums[max]) {
                    max = index;
                }
            }
            TreeNode root = new TreeNode(nums[max]);
            root.left = helper(nums, start, max - 1);
            root.right = helper(nums, max + 1, end);
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
