import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        helper(root, sum, result, new LinkedList<>());
        return result;
    }

    private void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(list));
        } else {
            helper(node.left, sum, result, list);
            helper(node.right, sum, result, list);
        }

        list.remove(list.size() - 1);
    }
}
