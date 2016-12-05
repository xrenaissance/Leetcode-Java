package com.inuker.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/12/3.
 */

public class PathSumIII {

    /**
     * 当root.val == Sum时，不要return，因为继续往下走可能有路径刚好加起来为0，典型的为[1,-2,1,-1]，目标和为-1
     * 这里隐藏了四条路径，[1,-2], [-2,1], [-1], [1,-2,1,-1]，如果在[1,-2]就return了，那就会掉了[1,-2,1,-1]
     * 可参考https://discuss.leetcode.com/category/562/path-sum-iii
     */

    private int count;

    /**
     * 有两种可能，算上当前root和不算当前root
     */
    public int pathSum(TreeNode root, int sum) {
        helperSum(root, sum);
        return count;
    }

    /**
     *  既可以算上，也可以不算上root
     */
    private void helperSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        // 算上root
        helper(root, sum);

        // 不算上root
        helperSum(root.left, sum);
        helperSum(root.right, sum);
    }

    /**
     * 一定要算上root
     */
    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count++;
           // return;
        }

        if (root.left != null) {
            helper(root.left, sum - root.val);
        }

        if (root.right != null) {
            helper(root.right, sum - root.val);
        }
    }

    /**
     * 这里给路径也打出来了
    private int count;

    public int pathSum(TreeNode root, int sum) {
        helperSum(root, sum, new ArrayList<TreeNode>());
        return count;
    }

    private void helperSum(TreeNode root, int sum, ArrayList<TreeNode> path) {
        if (root == null) {
            return;
        }
        helper(root, sum, path);
        helperSum(root.left, sum, new ArrayList<TreeNode>());
        helperSum(root.right, sum, new ArrayList<TreeNode>());
    }

    private void helper(TreeNode root, int sum, ArrayList<TreeNode> path) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
//            for (int i = 0; i < path.size(); i++) {
//                System.out.print(path.get(i).val + " ");
//            }
//            System.out.print(root.val);
//            System.out.println();

            count++;
//            return;
        }

        if (root.left != null) {
            path.add(root);
            helper(root.left, sum - root.val, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root);
            helper(root.right, sum - root.val, path);
            path.remove(path.size() - 1);
        }
    }*/
}
