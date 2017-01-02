package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeLinkNode;
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
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public String removeKdigits(String num, int k) {
        for (int i = 0, j; i < k && num.length() > 0; i++) {
            num = removeKdigits(num);
            for (j = 0; j < num.length() && num.charAt(j) == '0'; j++);
            num = num.substring(j);
        }
        return num.length() == 0 ? "0" : num;
    }

    public String removeKdigits(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (i + 1 < num.length()) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    return num.substring(0, i) + num.substring(i + 1);
                }
            } else {
                return num.substring(0, i);
            }
        }
        return null;
    }

}
