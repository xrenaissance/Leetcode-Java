import java.util.*;

public class Main {

    public  String longestPalindrome(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            helper(s, i - 1, i + 1, res);
            helper(s, i, i + 1, res);
        }
        return s.substring(res[1], res[1] + res[0]);
    }

    private void helper(String s, int left, int right, int[] res) {
        for ( ; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
        }
        int len = --right - ++left + 1;
        if (len > res[0]) {
            res[0] = len;
            res[1] = left;
        }
    }

//    public static String longestPalindrome(String s) {
//        if (s.length() == 0) {
//            return "";
//        }
//        int max = 0, idx = -1;
//        for (int i = 0; i < s.length(); i++) {
//            int len = findLen(s, i);
//            if (len > max) {
//                max = len;
//                idx = i;
//            }
//        }
//        if (max % 2 == 0) {
//            return s.substring(idx - max / 2 + 1, idx + max / 2 + 1);
//        } else {
//            return s.substring(idx - max / 2, idx + max / 2 + 1);
//        }
//    }
//
//    private static int findLen(String s, int index) {
//        int len1 = 1;
//        for (int i = 1; i <= s.length(); i++) {
//            int i1 = index - i, i2 = index + i;
//            if (i1 < 0 || i2 >= s.length() || s.charAt(i1) != s.charAt(i2)) {
//                break;
//            }
//            len1 += 2;
//        }
//        int len2 = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int i1 = index - i, i2 = index + i + 1;
//            if (i1 < 0 || i2 >= s.length() || s.charAt(i1) != s.charAt(i2)) {
//                break;
//            }
//            len2 += 2;
//        }
//        return Math.max(len1, len2);
//    }

    public static void main(String[] args) {
        String s = longestPalindrome("cbbd");
        System.out.println(s);
    }
}
