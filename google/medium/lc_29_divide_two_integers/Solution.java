package google.medium.lc_29_divide_two_integers;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335
 * would be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * Note: Assume we are dealing with an environment that could only store
 * integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For this
 * problem, if the quotient is strictly greater than 2^31 - 1, then return 231 -
 * 1, and if the quotient is strictly less than -231, then return -231.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 * 
 */

public class Solution {
    public int divide (int dividend, int divisor) {
        if (divisor == 0) return 1;
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long tempDividend = Math.abs((long) dividend); //ex 10
        long tempDivisor = Math.abs((long) divisor); // ex 3

        int quotient = 0;
        while (tempDividend >= tempDivisor) { // while 10 >= 3
            long temp = tempDivisor;
            int multiple = 1;

            while ((temp << 1) <= tempDividend) {
                temp <<= 1;
                multiple <<= 1; 
            }

            tempDividend -= temp;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3)); // expect: 3
        System.out.println(s.divide(Integer.MIN_VALUE, -1)); // expect: max value
        System.out.println(s.divide(0, 12)); // expect: 0
        System.out.println(s.divide(12, 0)); //expect: 1
    }
}