package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<>();

        int i = 0, j = 0, count = 0;
        for (i = 0; i < words.length; i = j) {
            for (j = i, count = 0; j < words.length; j++) {
                if (count + words[j].length() + j - i > maxWidth) {
                    break;
                }
                count += words[j].length();
            }
            StringBuilder sb = new StringBuilder();
            if (j == words.length || j - i == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
            } else {
                int space = (maxWidth - count) / (j - i - 1);
                int extra = maxWidth - count - space * (j - i - 1);
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k == j - 1) {
                        break;
                    }
                    for (int m = 0; m < space; m++) {
                        sb.append(" ");
                    }
                    if (extra-- > 0) {
                        sb.append(" ");
                    }
                }
            }
            list.add(sb.toString());
        }

        return list;
    }
}
