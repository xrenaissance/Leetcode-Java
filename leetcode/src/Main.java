import java.util.*;

public class Main {

    public static class Solution {

        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            for (char c : tasks) {
                count[c - 'A']++;
            }
            Arrays.sort(count);
            int i = 25;
            for ( ; i >= 0 && count[i] == count[25]; i--);
            return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
