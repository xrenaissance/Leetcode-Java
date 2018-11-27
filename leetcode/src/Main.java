import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        public int kEmptySlots(int[] flowers, int k) {
            int[] days = new int[flowers.length];
            for (int i = 0; i < flowers.length; i++) days[flowers[i] - 1] = i + 1;
            int left = 0, right = k + 1, res = Integer.MAX_VALUE;
            for (int i = left + 1; i <= right && right < days.length; i++) {
                if (i == right) {
                    res = Math.min(res, Math.max(days[left], days[right]));
                }

                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = k + 1 + i;
                }
            }
            return (res == Integer.MAX_VALUE) ? -1 : res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeMap<Integer, Boolean> map = new TreeMap<>();
        int[] nums = {4, 1, 7, 5, 2, 8, 10, 0};
        for (int n : nums) {
            map.put(n, true);
        }
        for (int k : map.keySet()) {
            System.out.print(k + " ");
        }

        int n = solution.kEmptySlots(new int[]{
                1, 2, 3
        }, 1);
        System.out.println(n);

    }
}
