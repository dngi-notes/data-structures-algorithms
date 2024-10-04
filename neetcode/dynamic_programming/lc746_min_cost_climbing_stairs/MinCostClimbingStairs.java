package neetcode.dynamic_programming.lc746_min_cost_climbing_stairs;

import java.util.*;

public class MinCostClimbingStairs {
    /*
     * You are given an integer array cost where cost[i] is the cost of ith step on
     * a staircase. Once you pay the cost, you can either climb one or two steps.
     * 
     * You can either start from the step with index 0, or the step with index 1.
     * 
     * Return the minimum cost to reach the top of the floor.
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0) return 0;
        if(n == 1) return cost[0];

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n -1], dp[n - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        String output = "Output: ";

        int[] cost1 = {10, 15, 20};
        System.out.println(output + mccs.minCostClimbingStairs(cost1));

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(output + mccs.minCostClimbingStairs(cost2));
    }
}
