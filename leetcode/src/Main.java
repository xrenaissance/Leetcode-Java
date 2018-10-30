import java.util.*;

public class Main {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(i > 0 ? dp[i - 1] + nums[i] : nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(i > 0 ? prev + nums[i] : nums[i], nums[i]);
            max = Math.max(max, prev);
        }
        return max;
    }

    public static void main(String[] args) {
    }
}
