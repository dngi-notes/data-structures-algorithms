package neetcode.dynamic_programming.lc322_coin_change;

import java.util.*;

public class CoinChange {
    /*
     * You are given an integer array coins representing coins of different
     * denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount
     * representing a target amount of money.
     * 
     * Return the fewest number of coins that you need to make up the exact target
     * amount. If it is impossible to make up the amount, return -1.
     * 
     * You may assume that you have an unlimited number of each coin.
     */
    public int coinChange(int[] coins, int amount) {
        /*
         * dynamic programming solution
         * - use a memo/dp array to store the minimum amount of coins needed to make up
         * amount 'i'
         */
        int[] dp = new int[amount + 1];
        dp[0] = 0; // it takes 0 coins to make up the amount 0

        // fill the array's values with the worst case minimum (int max in this case)
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        // build from 1 to the target amount 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        String output = "Output: ";

        int[] coins1 = { 1, 5, 10 };
        System.out.println(output + cc.coinChange(coins1, 12));
    }
}
