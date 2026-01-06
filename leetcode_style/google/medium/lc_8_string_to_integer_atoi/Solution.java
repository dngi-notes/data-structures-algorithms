package google.medium.lc_8_string_to_integer_atoi;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer.
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 
 * Whitespace: Ignore any leading whitespace (" ").
 * 
 * Signedness: Determine the sign by checking if the next character is '-' or
 * '+', assuming positivity if neither present.
 * 
 * Conversion: Read the integer by skipping leading zeros until a non-digit
 * character is encountered or the end of the string is reached. If no digits
 * were read, then the result is 0.
 * 
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231
 * - 1], then round the integer to remain in the range. Specifically, integers
 * less than -231 should be rounded to -231, and integers greater than 231 - 1
 * should be rounded to 231 - 1.
 * 
 */
public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int len = s.length();
        int index = 0;
        long result = 0;
        int sign = 1;

        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        if (index < len && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        while (index < len && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (result > (Integer.MAX_VALUE / 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        result *= sign;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.myAtoi("42")); // expected: 42
        System.out.println(s.myAtoi("-042")); // expected: -42
        System.out.println(s.myAtoi("1337c0d3")); // expected : 1337
        System.out.println(s.myAtoi("0-1")); // expected: 0
        System.out.println(s.myAtoi("words and -97")); // expected: 0
    }
}
