import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.EMPTY_LIST;
        }

        List<TreeNode>[] map = new LinkedList[n + 1];
        map[0] = new LinkedList<>();
        map[0].add(null);

        for (int i = 1; i <= n; i++) {
            map[i] = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : map[j - 1]) {
                    for (TreeNode right : map[i - j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = clone(right, j);
                        map[i].add(root);
                    }
                }
            }
        }

        return map[n];
    }

    public TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }

    public static void main(String[] args) {

    }
}
