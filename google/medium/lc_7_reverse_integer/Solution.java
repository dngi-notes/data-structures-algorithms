package google.medium.lc_7_reverse_integer;

/**
 * given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the 
 * value to go over the signed 32-bit integer range [-2^31, 2^31 - 1], return 0 
 */

public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;

        int extracted = x;
        int currentSum = 0;
        while (extracted != 0) {
            if (currentSum > Integer.MAX_VALUE / 10 || currentSum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = extracted % 10;
            currentSum *= 10;
            currentSum += digit;
            extracted = extracted / 10;
        }
        
        return currentSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123)); // expected: 321
        System.out.println(s.reverse(-123)); // expected: -321
        System.out.println(s.reverse(120)); // expected: 21
        System.out.println(s.reverse(1534236469)); // expected: 0
    }
}