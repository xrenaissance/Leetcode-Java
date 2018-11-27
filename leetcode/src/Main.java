import java.util.*;

public class Main {

    public static class Solution {

        public int findKthLargest(int[] nums, int k) {
            shuffle(nums);
            return findKthLargest(nums, 0, nums.length - 1, k);
        }

        private void shuffle(int[] nums) {
            Random rnd = new Random(System.currentTimeMillis());
            for (int i = nums.length - 1; i > 1; i--) {
                int index = rnd.nextInt(i + 1);
                swap(nums, index, i);
            }
        }

        public int findKthLargest(int[] nums, int start, int end, int k) {
            int index = partition(nums, start, end);
            int count = end - index + 1;
            if (count < k) {
                return findKthLargest(nums, start, index - 1, k - count);
            } else if (count > k) {
                return findKthLargest(nums, index + 1, end, k);
            } else {
                return nums[index];
            }
        }

        private int partition(int[] nums, int start, int end) {
            int left = start, right = end -1, pivot = nums[end];
            for (int i = start; i < right; ) {
                if (nums[i] < pivot) {
                    swap(nums, left++, i++);
                } else if (nums[i] > pivot) {
                    swap(nums, right--, i);
                } else {
                    i++;
                }
            }
            swap(nums, left, end);
            return left;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
