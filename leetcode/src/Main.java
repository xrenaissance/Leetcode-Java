import java.util.*;

public class Main {

    public static class Solution {

        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int n : nums) {
                int cnt = map.getOrDefault(n, 0) + 1;
                map.put(n, cnt);
                max = Math.max(max, cnt);
            }
            List<Integer>[] lists = new ArrayList[max + 1];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int freq = entry.getValue();
                if (lists[freq] == null) {
                    lists[freq] = new ArrayList<>();
                }
                lists[freq].add(entry.getKey());
            }
            List<Integer> result = new ArrayList<>();
            for (int i = max; i >= 0 && result.size() <= k; i--) {
                if (lists[i] != null) {
                    result.addAll(lists[i]);
                }
            }
            return result.subList(0, k);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
