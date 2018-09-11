import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        List<Integer> list = null;

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (list == null) {
                list = new ArrayList<>();
            }

            list.add(node.val);

            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                result.add(0, list);
                list = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
