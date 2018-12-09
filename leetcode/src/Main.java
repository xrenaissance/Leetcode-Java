import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            helpr(root, sum, new ArrayList<>(), result);
            return result;
        }

        private void helpr(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
            if (root == null) {
                return;
            }

            list.add(root.val);

            if (root.left == null && root.right == null && root.val == sum) {
                result.add(new ArrayList<>(list));
            } else {
                helpr(root.left, sum - root.val, list, result);
                helpr(root.right, sum - root.val, list, result);
            }

            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
