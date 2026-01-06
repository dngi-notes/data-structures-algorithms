package random_leetcode.lc166_fraction_to_recuring_decimal;

import java.util.*;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * If multiple answers are possible, return any of them.
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */
public class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
     
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }

            map.put(num, sb.length());
            num *= 10;
            sb.append(num / den);
            num %= den;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(4, 333));
    }
}