package amazon.easy.lc746_min_cost_climbing_stairs;

import neetcode.advanced_graphs.lc1584_min_cost_to_connect_all_points.MinCost;

public class MinCostClimbing {
    /*
     * You are given an integer array cost where cost[i] is the cost of ith step on
     * a staircase. Once you pay the cost, you can either climb one or two steps.
     * 
     * You can either start from the step with index 0, or the step with index 1.
     * 
     * Return the minimum cost to reach the top of the floor.
     */
    public int minCostClimbingStairsRecursive(int[] cost) {
        int n = cost.length;
        if(n == 0) {
            return -1;
        }

        if(n == 1) {
            return cost[0];
        }

        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int i) {
        if(i < 0) {
            return 0;
        }

        if(i == 0 || i == 1) {
            return cost[i];
        }

        return cost[i] + Math.min(minCost(cost, i - 1), minCost(cost, i - 2));
    }
    public static void main(String[] args) {
        MinCostClimbing mcc = new MinCostClimbing();
        String output = "Output: ";

        int[] cost1 = {10, 15, 20};
        System.out.println(output + mcc.minCostClimbingStairsRecursive(cost1));
    }
}
