import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, false);
    }

    public static int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return -1;
        }
        return flag ? Math.max(dfs(root.left, true) + 1, dfs(root.right, true) + 1) :
                Math.max(Math.max(dfs(root.left, false), dfs(root.right, false)),
                        dfs(root.left, true) + 2 + dfs(root.right, true));
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);
        int len = diameterOfBinaryTree(node1);
        System.out.println(String.format("len = %d", len));
    }
}
