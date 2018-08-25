import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }

        if (root.val > R) {
            root.right = null;
            return trimBST(root.left, L, R);
        }

        if (root.val < L) {
            root.left = null;
            return trimBST(root.right, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
    }
}
