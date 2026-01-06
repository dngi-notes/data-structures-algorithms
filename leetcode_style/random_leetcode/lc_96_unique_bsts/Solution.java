package random_leetcode.lc_96_unique_bsts;

public class Solution {
    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                cache[nodes] += cache[root - 1] * cache[nodes - root];
            }
        }

        return cache[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int test1 = 3;
        System.out.println(sol.numTrees(test1));
    }
}
