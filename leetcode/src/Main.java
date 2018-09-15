import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public int rob(TreeNode root) {
        int[] val = helper(root);
        return Math.max(val[0], val[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] value = new int[2];
        value[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        value[1] = node.val + left[0] + right[0];
        return value;
    }

    public static void main(String[] args) {
    }
}
