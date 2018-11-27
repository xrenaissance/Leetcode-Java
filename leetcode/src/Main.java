import java.util.*;

public class Main {

    public static class Solution {

        public String nearestPalindromic(String n) {
            long val = Long.parseLong(n);
            for (int i = 0; ; i++) {
                long k1 = val - i, k2 = val + i;
                if (isPalindrome(k1)) {
                    return String.valueOf(k1);
                }
                if (isPalindrome(k2)) {
                    return String.valueOf(k2);
                }
            }
        }

        private boolean isPalindrome(long k) {
            long x = k, rev = 0;
            for ( ; k > 0; ) {
                rev = rev * 10 + k % 10;
                k /= 10;
            }
            return rev == x;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.nearestPalindromic("807045053224792883");
        System.out.println(s);
    }
}
