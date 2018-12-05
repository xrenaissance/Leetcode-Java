import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {


        public int candy(int[] ratings) {
            int[] candys = new int[ratings.length];

            Arrays.fill(candys, 1);

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candys[i] = candys[i - 1] + 1;
                }
            }
            int sum = candys[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candys[i] = Math.max(candys[i], candys[i + 1] + 1);
                }
                sum += candys[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[] {1, 3, 2, 2, 1}));
//        System.out.println(solution.candy(new int[] {1, 2, 2}));
    }
}
