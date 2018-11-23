import java.util.*;

public class Main {

    public static class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> words = new HashSet<>(wordList);
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            Queue<String> next = new LinkedList<>();
            int length = 1;

            while (!queue.isEmpty()) {
                String s = queue.poll();

                if (s.equals(endWord)) {
                    return length;
                }

                if (!words.isEmpty()) {
                    StringBuilder sb = new StringBuilder(s);
                    for (int i = 0; i < s.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == s.charAt(i)) {
                                continue;
                            }

                            sb.setCharAt(i, c);
                            String st = sb.toString();

                            if (words.contains(st)) {
                                next.offer(st);
                                words.remove(st);
                            }
                        }
                        sb.setCharAt(i, s.charAt(i));
                    }
                }

                if (queue.isEmpty()) {
                    queue.addAll(next);
                    next.clear();
                    length++;
                }
            }

            return 0;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.ladderLength("hit", "cog", Arrays.asList(new String[]{
                "hot", "dot", "dog", "lot", "log"
        }));
        System.out.println(len);
    }
}
