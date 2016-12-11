package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/12.
 */

public class Solution {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), start = 0;
        for ( ; rows > 0; rows--) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                for ( ; start >= 0 && s.charAt((start - 1) % len) != ' '; start--);
            }
        }
        return start / len;
    }

}
