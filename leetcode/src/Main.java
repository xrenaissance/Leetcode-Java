import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return dfs(root, new int[1]) - 1;
        }

        private int dfs(TreeNode root, int[] len) {
            if (root == null) {
                return 0;
            }

            int[] lt = new int[1];
            int[] rt = new int[1];

            int left = dfs(root.left, lt);
            int right = dfs(root.right, rt);

            len[0] = Math.max(lt[0], rt[0]) + 1;

            return Math.max(Math.max(left, right), lt[0] + rt[0] + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = new TreeNode(1);
        System.out.println(f);
    }
}
