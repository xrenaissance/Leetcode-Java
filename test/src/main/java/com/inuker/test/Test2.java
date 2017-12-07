package com.inuker.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by liwentian on 2017/12/5.
 */

public class Test2 {

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        LinkedList<String> result = new LinkedList<>(Arrays.asList("JFK"));
        dfs("JFK", map, result, tickets.length);
        return result;
    }

    boolean dfs(String airport, HashMap<String, ArrayList<String>> map, LinkedList<String> route, int n) {
        if (route.size() == n + 1) {
            return true;
        }
        if (!map.containsKey(airport) || map.get(airport).isEmpty()) {
            return false;
        }
        ArrayList<String> list = map.get(airport);
        for (int i = 0; i < list.size(); i++) {
            String target = list.remove(i);

            route.add(target);
            if (dfs(target, map, route, n)) {
                return true;
            }
            route.removeLast();

            list.add(i, target);
        }
        return false;
    }
}
