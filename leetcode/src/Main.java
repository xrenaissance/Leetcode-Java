import java.util.*;

public class Main {

    public static class Solution {

        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            dfs(s, 0, new LinkedList<>(), result);
            return new ArrayList<>(result);
        }

        private void dfs(String s, int index, Deque<String> ips, List<String> result) {
            if (ips.size() > 4) {
                return;
            }
            if (index >= s.length()) {
                if (ips.size() == 4) {
                    result.add(String.join(".", ips));
                }
                return;
            }
            for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
                String t = s.substring(index, index + i);
                int k = Integer.parseInt(t);
                if (i == 3 && k > 255) {
                    break;
                }
                ips.offer(t);
                dfs(s, index + i, ips, result);
                ips.pollLast();

                if (k == 0) {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
