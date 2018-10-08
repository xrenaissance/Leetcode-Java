import java.util.HashMap;

/**
 * https://leetcode.com/articles/two-sum/
 */
public class TwoSum {

    /**
     * 如果符合条件的不止一组呢？则找到一组就从map删除一组
     * 要注意排除index != i
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[] {
                        i, index
                };
            }
        }
        return null;
    }

    /**
     * 只循环一轮
     * 要注意map.put要放在for末尾，对于case[3, 3], target=6的情况，如果放在开头会覆盖第一个3
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = map.getOrDefault(target - nums[i], -1);
            if (k >= 0 && k != i) {
                return new int[] {i, k};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
