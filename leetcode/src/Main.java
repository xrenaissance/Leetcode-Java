import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode node1 = new TreeNode(1, node2, node5);
        flatten(node1);

        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.right;
        }
    }
}
