public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(nums, start, max - 1);
        root.right = constructMaximumBinaryTree(nums, max + 1, end);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
}
