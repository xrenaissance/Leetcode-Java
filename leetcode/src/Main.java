import java.util.*;

public class Main {

    // 1 5 1
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1, j;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        if (i > 0) {
            for (j = i; j < nums.length; j++) {
                if (nums[j] <= nums[i - 1]) {
                    break;
                }
            }
            swap(nums, i - 1, j - 1);
        }
        revert(nums, i, nums.length - 1);
    }

    private void revert(int[] nums, int start, int end) {
        for ( ; start < end; start++, end--) {
            swap(nums, start, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
    }
}
