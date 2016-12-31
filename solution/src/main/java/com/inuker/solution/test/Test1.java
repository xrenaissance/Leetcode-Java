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

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
        for (TreeLinkNode p = root; p != null; p = p.next) {
            if (p.left != null) {
                cur.next = p.left;
                cur = cur.next;
            }
            if (p.right != null) {
                cur.next = p.right;
                cur = cur.next;
            }
        }
        connect(dummy.next);
    }
}
