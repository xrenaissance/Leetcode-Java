import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        for (TreeNode node = root; node != null; node = node.left, left++);
        for (TreeNode node = root; node != null; node = node.right, right++);
        if (left == right) {
            return (1 << left) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
    }
}
