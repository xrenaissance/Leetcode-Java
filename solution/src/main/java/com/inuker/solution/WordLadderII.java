package com.inuker.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * TestCases
 * "a", "c", ["a", "b", "c"]
 * "hit", "cog", ["hot","cog","dot","dog","hit","lot","log"]
 * "hit", "cog", ["hot","hit","cog","dot","dog"]
 * "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
 */
public class WordLadderII {

    class WordNode {
        String word;
        int numSteps;
        WordNode pre;

        public WordNode(String word, int numSteps, WordNode pre) {
            this.word = word;
            this.numSteps = numSteps;
            this.pre = pre;
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));

        // 假如dict中有start则删掉
        dict.remove(start);
        dict.add(end);

        HashSet<String> visited = new HashSet<String>();

        int minStep = Integer.MAX_VALUE, preNumSteps = 0;

        while (!queue.isEmpty()) {
            WordNode top = queue.poll();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if (word.equals(end)) {
                minStep = Math.min(minStep, currNumSteps);

                if (currNumSteps == minStep) {
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while (top.pre != null) {
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                } else {
                    /**
                     * 这里可以退出了，因为当前层已经大于最短路径了
                     */
                    break;
                }
            }

            /**
             * 只有上一层都走完了才能将word从dict中删除，因为同一层同一个单词可能会被多次利用
             * 比如上一层的dot和hog都能对应到本层的hot，那么hot就要重复利用，对应着两条路径
             * 只有本层过完了才能将hot从dict中删掉
             */
            if (preNumSteps < currNumSteps) {
                dict.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            /**
             * 这里为了提高效率，如果dict为空，下面的代码都没意义，所以提前返回
             */
            if (dict.isEmpty()) {
                continue;
            }

            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if ('a' + j == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) ('a' + j));
                    String newWord = sb.toString();
                    if (dict.contains(newWord)) {
                        /**
                         * 这里就是要重复加到queue里面，对应着最后可能有多条路径
                         */
                        queue.add(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                }
                sb.setCharAt(i, c);
            }
        }

        return result;
    }
}
