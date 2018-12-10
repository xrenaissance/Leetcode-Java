import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                for ( ; j < i && map.get(c) > 1; j++) {
                    char cc = s.charAt(j);
                    map.put(cc, map.get(cc) - 1);
                }
                max = Math.max(max, i - j + 1);
            }
            return max;
        }

        public int lengthOfLongestSubstring(String s) {
            int[] count = new int[256];
            int max = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count[c]++;
                for ( ; j < i && count[c] > 1; j++) {
                    count[s.charAt(j)]--;
                }
                max = Math.max(max, i - j + 1);
            }
            return max;
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
