package neetcode.dynamic_programming.lc322_coin_change;

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
        if(coins == null || coins.length <= 0) {
            return 0;
        }

        if(amount == 0) {
            return 0;
        }

        int n = coins.length;
        int result = coinChangeHelper(coins, n, amount);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChangeHelper(int[] coins, int n, int amount) {
        if(amount == 0) {
            return 0;
        }

        if(amount < 0 || n <= 0) {
            return Integer.MAX_VALUE;
        }

        int includeCoin = coinChangeHelper(coins, n, amount - coins[n - 1]);
        int excludeCoin = coinChangeHelper(coins, n - 1, amount);

        if(includeCoin != Integer.MAX_VALUE) {
            includeCoin++;
        }

        return Math.min(includeCoin, excludeCoin);
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        String output = "Output: ";

        int[] coins1 = {1, 5, 10};
        System.out.println(output + cc.coinChange(coins1, 12));
    }
}
