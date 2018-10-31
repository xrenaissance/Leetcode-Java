import java.util.*;

public class Main {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = 0, m = x;
        for ( ; x > 0; x /= 10) {
            n = n * 10 + x % 10;
        }
        return n == m;
    }

    public static void main(String[] args) {
    }
}
