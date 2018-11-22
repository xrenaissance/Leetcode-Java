import java.util.*;

public class Main {

    public double myPow(double x, int n) {
        return myPow(x, n);
    }

    private double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        double res = myPow(x, n / 2);
        if (n % 2 != 0) {
            return res * res * x;
        } else {
            return res * res;
        }
    }

    public static void main(String[] args) {
    }
}
