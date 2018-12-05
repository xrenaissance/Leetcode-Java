import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        public int maxDistToClosest(int[] seats) {
            int max = 0;

            int[] zone = new int[2];
            for (int index = 0; index < seats.length; ) {
                Arrays.fill(zone, -1);
                index = nextFree(seats, index, zone);
                if (zone[0] == 0 || zone[1] == seats.length - 1) {
                    max = Math.max(max, zone[1] - zone[0] + 1);
                } else {
                    max = Math.max(max, (zone[1] - zone[0] + 2) / 2);
                }
            }

            return max;
        }

        private int nextFree(int[] seats, int start, int[] zone) {
            boolean enter = false;
            for (int i = start, j = 0; i <= seats.length; i++) {
                if (i < seats.length && seats[i] == 0) {
                    if (!enter) {
                        enter = true;
                        j = i;
                    }
                } else {
                    if (enter) {
                        zone[0] = j;
                        zone[1] = i - 1;
                        return i + 1;
                    }
                }
            }
            return seats.length;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.maxDistToClosest(new int[]{1,0,0,0,1,0,1});
        System.out.println(s);
    }
}
