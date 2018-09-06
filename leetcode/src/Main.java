import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) {
            return right != null ? root : root.left;
        } else {
            return root.right;
        }
    }

    public static void main(String[] args) {
    }
}
