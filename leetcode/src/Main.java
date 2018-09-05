import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        while (!stack1.isEmpty() || left != null) {
            if (left != null) {
                if (right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                stack1.push(left);
                stack2.push(right);
                left = left.left;
                right = right.right;
            } else {
                if (right != null) {
                    return false;
                }
                if (stack2.isEmpty()) {
                    return false;
                }
                left = stack1.pop().right;
                right = stack2.pop().left;
            }
        }
        return stack2.isEmpty() && right == null;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
    }
}
