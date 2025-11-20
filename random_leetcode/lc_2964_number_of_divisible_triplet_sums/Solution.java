package random_leetcode.lc_2964_number_of_divisible_triplet_sums;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * 2964. Number of Divisible Triplet Sums
     * 
     * You are given a 0-indexed integer array nums and an integer d.
     * Return the number of triplets (i, j, k) such that:
     * 
     * 0 ≤ i < j < k < nums.length
     * (nums[i] + nums[j] + nums[k]) % d == 0
     * 
     * Example 1:
     * Input: nums = [3,3,4,7,8], d = 5
     * Output: 3
     * Explanation: The triplets are (0,1,2), (0,2,4), (1,2,4).
     * 
     * Example 2:
     * Input: nums = [3,3,3,3], d = 3
     * Output: 4
     * Explanation: Any triplet you pick sums to 9, which is divisible by 3.
     * 
     * Example 3:
     * Input: nums = [3,3,3,3], d = 6
     * Output: 0
     * Explanation: Any triplet sums to 9, which is not divisible by 6.
     * 
     * Constraints:
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 10^9
     * 1 <= d <= 10^9
     */
    public int divisibleTripletSumsBf(int[] nums, int d) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int numberOfDivisibleTripletSums = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] + nums[j] + nums[k]) % d == 0) {
                        numberOfDivisibleTripletSums++;
                    }
                }
            }
        }

        return numberOfDivisibleTripletSums;
    }

    public long divisibleTripletSums(int[] nums, int d) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        // building frequency map of remainders
        long[] freq = new long[d];
        for (int num : nums) {
            int r = num % d;
            freq[r]++;
        }

        // iterate over remainder triplets
        for (int a = 0; a < d; a++) {
            if (freq[a] == 0) continue;

            for (int b = a; b < d; b++) {
                if (freq[b] == 0) continue;

                int c = (d - (a + b) % d) % d;
                if (c < b || freq[c] == 0) continue;

                if (a == b && b == c) {
                    count += freq[a] * (freq[a] - 1) * (freq[a] - 2) / 6;
                } else if (a == b) {
                    count += (freq[a] * (freq[a] - 1) / 2) * freq[c];
                } else if (b == c) {
                    count += freq[a] * (freq[b] * (freq[b] - 1) / 2);
                } else {
                    count += freq[a] * freq[b] * freq[c];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.divisibleTripletSums(new int[]{3, 3, 4, 7, 8}, 5)); // expected: 3
        System.out.println(s.divisibleTripletSums(new int[]{3, 3, 3, 3}, 3)); // expected: 4
    }
}
