package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/28.
 */

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxSum = new int[] {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    /**
     * 这个函数用于返回包含node的单边最大和，但是maxSum是双边的
     */
    private int dfs(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, maxSum);
        int right = dfs(node.right, maxSum);
        int sum = node.val;

        if (left > 0) {
            sum += left;
        }

        if (right > 0) {
            sum += right;
        }

        maxSum[0] = Math.max(maxSum[0], sum);

        int max = Math.max(left, right);
        return max > 0 ? max + node.val : node.val;
    }
}
