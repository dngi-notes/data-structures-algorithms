package random_leetcode.lc_3006_finding_beautiful_indices_in_the_given_array_i;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
/**
 * phase 2
 * 
 * given:
 * - a String s
 * - two patterns "a", "b"
 * 
 * return two lists:
 * - all starting indices where a appears in s
 * - all starting indices where b appears in s
 * 
 * e.g. 
 * input:
 * s = "abcabdab"
 * a = "ab"
 * b = "ba"
 * output: a indices: [0, 3, 6]
 *         b indices: []
 * 
 */
    public List<List<Integer>> findAllStartingIndices(String s, String a, String b) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }

        int n = s.length();
        List<Integer> allStartA = new ArrayList<>();
        List<Integer> allStartB = new ArrayList<>();
        for (int i = 0; i < n - a.length() + 1; i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                allStartA.add(i);
            }
        }

        for (int i = 0; i < n - b.length() + 1; i++) {
            if (s.substring(i, i + b.length()).equals(b)) {
                allStartB.add(i);
            }
        }

        res.add(allStartA);
        res.add(allStartB);
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findAllStartingIndices("abcabdab", "ab", "ba")); // expected: [a: [0, 3, 6], b: []]
        System.out.println(s.findAllStartingIndices("aaaaa", "aa", "aaa")); // expected: [a: [0, 1, 2, 3], b: [0, 1, 2]]
        System.out.println(s.findAllStartingIndices("xyzxyzxyz", "xyz", "yz")); // expected: [a: [0, 3, 6], b: [1, 4, 7]]
    }
}
