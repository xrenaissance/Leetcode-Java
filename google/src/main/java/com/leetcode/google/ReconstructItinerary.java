package com.leetcode.google;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by liwentian on 2017/9/2.
 */

public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, String> map = new HashMap<>();
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + ", " + s2);
            }
        });

//        map.computeIfAbsent("china", new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return null;
//            }
//        };
        return null;
    }

}

/**
JFK ATL SFO
 JFK SFO ATL JFK
 */