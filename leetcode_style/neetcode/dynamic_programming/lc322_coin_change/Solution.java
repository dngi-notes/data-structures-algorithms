package neetcode.dynamic_programming.lc322_coin_change;

import java.util.Arrays;

public class Solution {
    private static final int INF = Integer.MAX_VALUE / 2; // avoid overflow
        public static int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                }
            }

            return dp[amount] == INF ? -1 : dp[amount];
        }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // expect: 3
        System.out.println(coinChange(new int[]{2}, 3)); // expect: -1
        System.out.println(coinChange(new int[]{1}, 0)); // expect: 0
    }
}

/* 
 * e.g.
 * coins = [1, 2, 5]
 * amount = 11
 * 
 * subproblem: find the min number of coins needed at each index [0, amount]
*/