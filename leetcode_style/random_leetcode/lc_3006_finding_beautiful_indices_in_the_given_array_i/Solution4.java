package random_leetcode.lc_3006_finding_beautiful_indices_in_the_given_array_i;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    /**
     * LeetCode 3006 — Finding Beautiful Indices in the Given Array I
     *
     * You are given:
     * - a string s
     * - two patterns a and b
     * - an integer k
     *
     * A beautiful index is an index i such that:
     * 1. The substring a occurs in s starting at index i.
     * 2. There exists some index j where substring b occurs in s.
     * 3. The distance condition holds: |i - j| <= k.
     *
     * Return:
     * - A list of all beautiful indices i, in increasing order.
     *
     * Notes:
     * - Patterns a and b may overlap.
     * - There may be many occurrences of a and b.
     * - The input size can be large, so the solution should be efficient
     * (O(n) or O(n log n)).
     *
     * Example:
     * s = "ababab", a = "ab", b = "ba", k = 1
     * a occurs at: [0, 2, 4]
     * b occurs at: [1, 3]
     * Beautiful indices: [0, 2, 4]
     */
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        int n = s.length();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        // find all indices where a and b occur
        for (int i = 0; i + a.length() <= n; i++) {
            if (s.startsWith(a, i))
                A.add(i);
        }
        System.out.println("All starting indices where a occurs: " + A);

        for (int i = 0; i + b.length() <= n; i++) {
            if (s.startsWith(b, i))
                B.add(i);
        }
        System.out.println("All starting indices where b occurs: " + B);

        // loop over b indices and skip the ones that are too far from any a index
        int j = 0;
        for (int aIndex : A) {
            while (j + 1 < B.size() && B.get(j) < aIndex - k) {
                j++;
            }

            if ((j < B.size() && Math.abs(B.get(j) - aIndex) <= k)
                    || (j - 1 >= 0 && Math.abs(B.get(j - 1) - aIndex) <= k)) {
                result.add(aIndex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution4 ss = new Solution4();
        System.out.println(ss.beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
    }
}