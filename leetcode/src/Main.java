import java.util.*;

public class Main {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int rain = 0;
        for (int i = 1; i < height.length - 1; i++) {
            rain += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return rain;
    }

    public static void main(String[] args) {
    }
}
