public class DiameterOfBinaryTree {

    /**
     * 这题和 124. Binary Tree Maximum Path Sum比较像
     * 都是分两种情况，一种是必须包括root的，带上必须包括left和right的单边结果;
     * 还有不是必须包括root的，对比left和right的双边结果
     * flag为true表示必须包括root，false表示不是必须包括root
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, false);
    }

    public int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return -1;
        }
        return flag ? Math.max(dfs(root.left, true) + 1, dfs(root.right, true) + 1) :
                Math.max(Math.max(dfs(root.left, false), dfs(root.right, false)),
                        dfs(root.left, true) + 2 + dfs(root.right, true));
    }
}
