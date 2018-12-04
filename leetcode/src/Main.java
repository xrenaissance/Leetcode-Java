import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    static class Man {
        int quality;
        int wage;

        Man(int a, int b) {
            quality = a;
            wage = b;
        }

        double ratio() {
            return (double) wage / quality;
        }
    }

    public static class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
            Queue<Man> queue = new PriorityQueue<>(new Comparator<Man>() {
                @Override
                public int compare(Man o1, Man o2) {
                    return o1.ratio() > o2.ratio() ? 1 : -1;
                }
            });
            for (int i = 0; i < quality.length; i++) {
                queue.offer(new Man(quality[i], wage[i]));
            }
            double money = Integer.MAX_VALUE, qsum = 0;
            Queue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
            while (!queue.isEmpty()) {
                Man man = queue.poll();
                qsum += man.quality;
                queue2.offer(man.quality);
                if (queue2.size() > K) {
                    qsum -= queue2.poll();
                }
                if (queue2.size() == K) {
                    money = Math.min(money, qsum * man.ratio());
                }
            }
            return money;
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
