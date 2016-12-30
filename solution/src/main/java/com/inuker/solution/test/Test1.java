package com.inuker.solution.test;

import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public String minWindow(String s, String t) {
        int[] cns = new int[256];
        int[] cnt = new int[256];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int count = 0, minLen = 0, minStart = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (++cns[c] <= cnt[c]) {
                ++count;
            }

            if (count >= t.length()) {
                for ( ; j < i; j++) {
                    char cc = s.charAt(j);
                    if (cnt[cc] == 0) {
                        continue;
                    }
                    if (cns[cc] > cnt[cc]) {
                        cns[cc]--;
                    } else {
                        break;
                    }
                }
                int len = i - j + 1;
                if (minLen == 0 || len < minLen) {
                    minLen = len;
                    minStart = j;
                }
            }
        }
        return minLen > 0 ? s.substring(minStart, minStart + minLen) : "";
    }
}
