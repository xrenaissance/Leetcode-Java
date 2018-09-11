import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }
        if (root.left == null) {
            return minDepth(root.right, depth + 1);
        }
        if (root.right == null) {
            return minDepth(root.left, depth + 1);
        }
        return Math.min(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1));
    }

    public static void main(String[] args) {

    }
}
