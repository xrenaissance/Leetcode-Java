package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/25.
 */

public class ShortestWordDistance {

    // 耗时3ms
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> indexs1 = new LinkedList<Integer>();
        List<Integer> indexs2 = new LinkedList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexs1.add(i);
            } else if (words[i].equals(word2)) {
                indexs2.add(i);
            }
        }

        int size1 = indexs1.size(), size2 = indexs2.size();
        int min = Math.abs(indexs1.get(size1 - 1) - indexs2.get(size2 - 1));
        for (int i = 0, j = 0; i < size1 && j < size2; ) {
            int index1 = indexs1.get(i);
            int index2 = indexs2.get(j);

            min = Math.min(min, Math.abs(index1 - index2));

            if (index1 < index2) {
                i++;
            } else if (index1 > index2) {
                j++;
            } else {
                return 0;
            }
        }

        return min;
    }
}
