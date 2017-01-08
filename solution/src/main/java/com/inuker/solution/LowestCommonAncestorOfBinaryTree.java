package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/16.
 */
public class LowestCommonAncestorOfBinaryTree {

    // 耗时12ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    /**
     * 这是迭代写法，另外考虑了p或者q不在树中的情况
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (parents.containsKey(p) && parents.containsKey(q)) {
                break;
            }

            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                parents.put(node.left, node);
            }

            if (node.right != null) {
                queue.add(node.right);
                parents.put(node.right, node);
            }
        }

        if (!parents.containsKey(p) || !parents.containsKey(q)) {
            return null;
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        for (TreeNode node = p; node != null; node = parents.get(node)) {
            set.add(node);
        }

        for (TreeNode node = q; node != null; node = parents.get(node)) {
            if (!set.add(node)) {
                return node;
            }
        }

        return null;
    }
}
