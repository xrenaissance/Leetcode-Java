import java.util.*;

public class BinaryTreePostorderTraversal {

    /**
     * 先序是中左右，中序是左中右，后序是左右中，所以我们可以给先序调整一下改成中右左，然后倒过来就成了左右中
     * @param root
     * @return
     */
    // 这里虽然最后的结果返回的是对的，但真正访问节点的顺序是不对的，root并不是最后访问的
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                results.add(0, root.val);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }
        return results;
    }


    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode last = null;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && last != peek.right) {
                    root = peek.right;
                } else {
                    result.add(peek.val);
                    last = stack.pop();
                }
            }
        }

        return result;
    }
}
