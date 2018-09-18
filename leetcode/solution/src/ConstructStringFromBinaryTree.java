/**
 * https://leetcode.com/articles/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {

    /**
     * 左子树如果为空'()'是不能省略的
     * 右子树如果为空可以省略
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        String left = "(" + tree2str(t.left) + ")";
        String right = t.right != null ? "(" + tree2str(t.right) + ")" : "";
        return t.val + left + right;
    }
}
