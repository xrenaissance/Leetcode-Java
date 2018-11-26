import java.util.*;

public class Main {

    public static class Solution {

        public int largestRectangleArea(int[] heights) {
            int[] indexes = new int[heights.length + 1];
            int top = -1, max = 0;

            for (int i = 0; i <= heights.length; ) {
                int height = i == heights.length ? 0 : heights[i];
                if (top < 0 || height > heights[indexes[top]]) {
                    indexes[++top] = i++;
                } else {
                    int k = heights[indexes[top--]];
                    int left = top < 0 ? 0 : (indexes[top] + 1);
                    max = Math.max(max, (i - 1 - left + 1) * k);
                }
            }

            return max;
        }

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
