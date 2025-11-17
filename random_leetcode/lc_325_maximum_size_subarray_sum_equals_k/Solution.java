package random_leetcode.lc_325_maximum_size_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * 325. Maximum Size Subarray Sum Equals k
     *
     * Description:
     * Given an integer array nums and an integer k,
     * return the maximum length of a subarray that sums exactly to k.
     *
     * If no such subarray exists, return 0.
     *
     * This problem may include negative numbers, so the sliding window
     * technique does NOT work. Prefix-sum + HashMap is required.
     *
     * Example 1:
     * Input:
     * nums = [1, -1, 5, -2, 3], k = 3
     *
     * Output:
     * 4
     *
     * Explanation:
     * The subarray [1, -1, 5, -2] sums to 3 and has length 4.
     *
     *
     * Example 2:
     * Input:
     * nums = [-2, -1, 2, 1], k = 1
     *
     * Output:
     * 2
     *
     * Explanation:
     * The subarray [-1, 2] sums to 1 and has length 2.
     *
     * Follow-up:
     * Can you do it in O(n) using prefix sums and a HashMap?
     */
    public int sum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumToFirstIndex = new HashMap<>();
        sumToFirstIndex.put(0, -1);

        int currSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (sumToFirstIndex.containsKey(currSum - k)) {
                int startIdx = sumToFirstIndex.get(currSum - k);
                int len = i - startIdx;
                maxLen = Math.max(maxLen, len);
            }

            sumToFirstIndex.putIfAbsent(currSum, i);            
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(s.sum(nums, k)); // expected output: 4


        int[] nums2 = new int[]{-2, -1, 2, 1};
        int k2 = 1;
        System.out.println(s.sum(nums2, k2)); // expected output: 2
    }
}
