package random_leetcode.lc_3006_finding_beautiful_indices_in_the_given_array_i;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * not confident enough to solve the problem as i am right now so I'm taking
     * this step by step
     * 
     * 1. easisest
     * GOAL: learn how to find all occurrences of a substring in a string
     * 
     * problem:
     * - given a string `s` and a pattern `a`, return a list of all
     * starting indices where a appears in `s`
     * 
     * example:
     * -s = "ababab"
     * -a = "ab"
     * output: [0, 2, 4]
     */
    public List<Integer> findAllOccurences(String s, String a) {
        if (s == null || s.isEmpty()) { return new ArrayList<>(); }

        int n = s.length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n - a.length() + 1; i++) {
            String stringOfSizeA = s.substring(i, i + a.length());
            System.out.println(stringOfSizeA);
            if (stringOfSizeA.equals(a)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findAllOccurences("ababab", "ab")); // expected: [0, 2, 4]
    }
}
