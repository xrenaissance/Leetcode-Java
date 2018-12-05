import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {

        public interface Master {
            int guess(String word);
        }


        public void findSecretWord(String[] wordlist, Master master) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                String word = wordlist[random.nextInt(wordlist.length)];
                int match = master.guess(word);
                List<String> list = new ArrayList<>();
                for (String s : wordlist) {
                    if (match(s, word) == match) {
                        list.add(s);
                    }
                }
                wordlist = list.toArray(new String[0]);
            }
        }

        private int match(String s, String t) {
            int match = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    match++;
                }
            }
            return match;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        double s = solution.mincostToHireWorkers(new int[] {
                3,1,10,10,1
        }, new int[] {
                4,8,2,2,7
        },3);

        System.out.println(s);
    }
}
