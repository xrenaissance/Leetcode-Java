import java.util.*;

public class Main {

    public static class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            HashMap<String, HashMap<String, Double>> table = new HashMap<>();
            for (int i = 0; i < equations.length; i++) {
                add(table, equations[i], values[i]);
            }
            double[] result = new double[queries.length];
            HashSet<String> visited = new HashSet<>();
            for (int i = 0; i < queries.length; i++) {
                visited.clear();
                result[i] = calc(table, visited, queries[i][0], queries[i][1]);
            }
            return result;
        }

        private double calc(HashMap<String, HashMap<String, Double>> table, HashSet<String> visited, String a, String b) {
            HashMap<String, Double> map = table.get(a);
            if (map == null) {
                return -1.0;
            }
            if (a.equals(b)) {
                return 1.0;
            }
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();

                if (visited.contains(key)) {
                    continue;
                }

                visited.add(key);

                double t = calc(table, visited, key, b);
                if (t != -1.0) {
                    return value * t;
                }

                visited.remove(key);
            }
            return -1.0;
        }

        private void add(HashMap<String, HashMap<String, Double>> table, String[] equation, double value) {
            HashMap<String, Double> map0 = table.get(equation[0]);
            HashMap<String, Double> map1 = table.get(equation[1]);
            if (map0 == null) {
                map0 = new HashMap<>();
                table.put(equation[0], map0);
            }
            if (map1 == null) {
                map1 = new HashMap<>();
                table.put(equation[1], map1);
            }
            map0.put(equation[1], value);
            map1.put(equation[0], 1 / value);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        double[] res = s.calcEquation(new String[][]{
                {"a", "b"}, {"b", "c"}
        }, new double[]{2.0, 3.0}, new String[][]{
                {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
        });
        for (double v : res) {
            System.out.println(v);
        }
    }
}
