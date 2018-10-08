import java.util.*;

public class Main {

    class TwoSum {

        HashMap<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int k : map.keySet()) {
                int n = map.getOrDefault(value - k, -1);
                if (value - k != k && n > 0) {
                    return true;
                }
                if (value - k == k && n > 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{3,2,3}, 6);
        System.out.println(String.format("%d - %d", res[0], res[1]));
    }
}
