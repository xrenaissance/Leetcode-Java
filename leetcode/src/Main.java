import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        int tilt = 0;

        public int findTilt(TreeNode root) {
            helper(root);
            return tilt;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = helper(root.left);
            int right = helper(root.right);
            tilt += Math.abs(left - right);
            return left + right + root.val;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
