package google.easy.lc69_sqrt_x;

public class Solution {
    /**
     * given a non-negative integer 'x',
     * return the square root of x rounded down to the nearest int
     * the returned integer should be a non-negative as well
     * 
     * cant use built in exponent functions or in built methods
     */
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;

        int left = 0;
        int right = x;

        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sqr = (long) mid * mid;

            if (sqr == x) {
                return mid;
            } else if (sqr < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0)); // expected: 0
        System.out.println(mySqrt(1)); // expected: 1
        System.out.println(mySqrt(4)); // expected: 2
        System.out.println(mySqrt(8)); // expected: 2
    }
}
