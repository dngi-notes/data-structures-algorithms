package random_leetcode.lc_1015_smallest_int_divisble_by_k;

public class Solution2 {
    /**
     * practice problem 2:
     * - find the first remainder of zero (if any)
     * - 1-indexed
     * - stop as soon as we hit a remainder of 0, or after n remainder generations
     * - if we dont find a 0 within n values, return -1
     * 
     * e.g:
     * in: n = 7, d = 3
     * out: 6 (the first index of 0 is 5 (+1 = 6))
     */
    public int findIndexOfFirstZero(int n, int d) {
        if (n == 0) return -1;
        int rem = d % n;
        int i = 0;

        while (i < n) {
            if (rem == 0) return i + 1;
            rem = (rem * 10 + d) % n;
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
        System.out.println(ss.findIndexOfFirstZero(7, 3)); // expected 6
        System.out.println(ss.findIndexOfFirstZero(8, 1)); // expected -1
    }
}
