package google.medium.lc50_pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long nLong = n;
        if (nLong < 0) {
            x = 1 / x;
            nLong = -nLong;
        }

        return powHelper(x, nLong);
    }

    private double powHelper(double x, long n) {
        if (n == 0) return 1;

        double half = powHelper(x * x, n / 2);
        return (n % 2 == 0) ? half : x * half;
    }
}
