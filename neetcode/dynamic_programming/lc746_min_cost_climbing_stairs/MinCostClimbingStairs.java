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
        
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        String output = "Output: ";

        int[] cost1 = {10, 15, 20};
        System.out.println(output + mccs.minCostClimbingStairs(cost1));
    }
}
