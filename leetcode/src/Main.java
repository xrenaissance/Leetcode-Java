import java.util.*;

public class Main {

    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') {
                dp[i] += i > 0 ? dp[i - 1] : 1;
            }
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
