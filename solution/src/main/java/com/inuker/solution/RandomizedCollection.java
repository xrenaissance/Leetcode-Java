package com.inuker.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class RandomizedCollection {

    private HashMap<Integer, HashSet<Integer>> map;
    private List<Integer> list = new ArrayList<Integer>();
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection () {
        map = new HashMap<Integer, HashSet<Integer>>();
        list = new Vector<Integer>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);

        if (!contains) {
            map.put(val, new HashSet<Integer>());
        }

        list.add(val);
        HashSet<Integer> index = map.get(val);
        index.add(list.size() - 1);

        return !contains;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        HashSet<Integer> indexes = map.get(val);

        if (indexes.isEmpty()) {
            return false;
        }

        int index = indexes.iterator().next();
        indexes.remove(index);

        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);

            map.get(last).remove(list.size() - 1);
            map.get(last).add(index);
        }

        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
