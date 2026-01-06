package google.medium.lc_16_3sum_closest;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * e.g.
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tripletSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(tripletSum - target) < Math.abs(closest - target)) {
                    closest = tripletSum;
                }

                if (tripletSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // expected: 2
        System.out.println(s.threeSumClosest(new int[]{0, 0, 0}, 1)); // expected: 0
        System.out.println(s.threeSumClosest(new int[]{3, 3, 2, 1, 3}, 9)); // expected: 9
    }
}
