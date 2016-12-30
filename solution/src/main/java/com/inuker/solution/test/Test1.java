package com.inuker.solution.test;

import com.inuker.solution.PalindromeLinkedList;

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

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            return s.length() == 1 && isEqual(s, p);
        }

        if (p.charAt(1) != '*') {
            return s.length() > 0 && isEqual(s, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() > 0) {
                if (isEqual(s, p)) {
                    return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
                } else {
                    return isMatch(s, p.substring(2));
                }
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    private boolean isEqual(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
}
