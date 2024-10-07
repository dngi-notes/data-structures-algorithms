package neetcode.dynamic_programming.lc213_house_robber_ii;

import java.util.*;

public class HouseRobber {
    /*
     * You are a professional robber planning to rob houses along a street. Each
     * house has a certain amount of money stashed. All houses at this place are
     * arranged in a circle. That means the first house is the neighbor of the last
     * one. Meanwhile, adjacent houses have a security system connected, and it will
     * automatically contact the police if two adjacent houses were broken into on
     * the same night.
     * 
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the
     * police.
     */
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(Arrays.copyOfRange(nums, 1, nums.length)), robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int robHelper(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        memo[n - 2] = Math.max(nums[n - 2], nums[n - 1]);

        for(int i = n - 3; i >= 0; i--) {
            memo[i] = Math.max(nums[i] + memo[i + 2], memo[i + 1]);
        }

        return memo[0];
    }
}
