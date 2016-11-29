package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/30.
 */

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        int[] kth = new int[1];
        inorderTraversal(root, k, kth);
        return kth[0];
    }

    private int inorderTraversal(TreeNode root, int k, int[] kth) {
        if (root == null) {
            return k;
        }

        k = inorderTraversal(root.left, k, kth);

        if (--k == 0) {
            kth[0] = root.val;
            return 0;
        }

        return inorderTraversal(root.right, k, kth);
    }
}
