package amazon.easy.lc338_counting_bits;

import java.util.Arrays;

public class CountingBits {
    /*
     * Given an integer n, return an array ans of length n + 1 such that for each i
     * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     */

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];      //n = 2 | ans:[0, 0, 0]

        for(int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        String output = "Output: ";

        System.out.println(output + Arrays.toString(cb.countBits(2))); // [0, 1, 1]
        System.out.println(output + Arrays.toString(cb.countBits(5))); // [0, 1, 1, 2, 1, 2]
    }
}
