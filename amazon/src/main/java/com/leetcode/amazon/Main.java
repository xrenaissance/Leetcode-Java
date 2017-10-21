package com.leetcode.amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by liwentian on 2017/10/16.
 */

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "ones");
        map.put("two", "twos");

        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
    }
}
