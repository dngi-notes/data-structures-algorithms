package random_leetcode.lc_1015_smallest_int_divisble_by_k;

import java.util.*;

public class Solution1 {
    /**
     * You are given two integers n and d, where:
     * d is a single digit from 0 to 9
     * n is a positive integer
     * You will construct a sequence of numbers:
     * d
     * dd
     * ddd
     * dddd
     * (each time adding digit d to the end)
     * 
     * your task is not to build the numbers directly but tYou are given two
     * integers n and d, where:
     * 
     * d is a single digit from 0 to 9
     * 
     * n is a positive integer
     * 
     * example 1:
     * n = 7
     * n = 3
     */
    public int[] buildRemainder(int n, int d) {
        List<Integer> result = new ArrayList<>();
        int rem = d % n;
        result.add(rem);
        int i = 1;
        while (i < n) {
            if (rem == 0) break;
            rem = (rem * 10 + d) % n;
            result.add(rem);
            System.out.println(rem);
            i++;
        }

        return result.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }

    public static void main(String[] args) {
        Solution1 ss = new Solution1();
        int n = 7;
        int d = 3;
        System.out.println(Arrays.toString(ss.buildRemainder(n, d)));
    }
}
