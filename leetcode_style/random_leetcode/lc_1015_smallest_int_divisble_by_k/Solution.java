package random_leetcode.lc_1015_smallest_int_divisble_by_k;

public class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k == 0 || k % 2 == 0 || k % 5 == 0) { return -1; }

        int rem = 1;
        int i = 1;
        while (i <= k) {
            if (rem % k == 0) {
                return i;
            }

            rem = (rem * 10 + 1) % k;
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.smallestRepunitDivByK(1));
    }
}
