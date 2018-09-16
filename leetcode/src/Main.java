import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

public class Main {

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int[] count = new int[1];
        helper(root, sum, 0, map, count);
        return count[0];
    }

    private void helper(TreeNode node, int target, int sum, HashMap<Integer, Integer> map, int[] count) {
        if (node == null) {
            return;
        }

        sum += node.val;
        if (map.containsKey(sum - target)) {
            count[0] += map.get(sum - target);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        helper(node.left, target, sum, map, count);
        helper(node.right, target, sum, map, count);

        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }

    public static void main(String[] args) {
    }
}
