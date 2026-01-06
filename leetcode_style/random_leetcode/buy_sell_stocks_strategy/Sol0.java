package random_leetcode.buy_sell_stocks_strategy;

/**
 * given:
 * int[] prices, where prices[i] is the stock price on day i
 * int[] strategy, where strategy can be either [-1, 0, 1]
 * 
 * profit = su
 */
public class Sol0 {
    public static long baseProfit(int[] prices, int[] strategy) {
        if (prices == null || prices.length == 0) return 0;

        int baseProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            baseProfit += prices[i] * strategy[i];
        }

        return baseProfit;
    }

    public static long profitAfterModification(int[] prices, int[] strategy, int k, int l) {
        if (prices == null || prices.length == 0) return 0;

        long baseProfit = baseProfit(prices, strategy);

        long oldContrib = 0;
        long newContrib = 0;
        for (int i = l; i <= l + k - 1; i++) {
            oldContrib += prices[i] * strategy[i];
        }

        for (int i = l + k/2; i <= l + k - 1; i++) {
            newContrib += prices[i];
        }

        return (baseProfit) - oldContrib + newContrib;
    }

    public static long calculateWindowGain(int[] prices, int[] strategy, int k, int l) {
        if (prices == null || prices.length == 0) return 0;

        long oldContrib = 0;
        long newContrib = 0;
        for (int i = l; i <= l + k - 1; i++) {
            oldContrib += prices[i] * strategy[i];
        }

        for (int i = l + k/2; i <= l + k - 1; i++) {
            newContrib += prices[i];
        }

        return newContrib - oldContrib;
    }

    public static long maxGainForWindowK(int[] prices, int[] strategy, int k) {
        long maxGain = 0;
        for (int i = 0; i <= prices.length - k; i++) {
            long gain = calculateWindowGain(prices, strategy, k, i);
            maxGain = Math.max(maxGain, gain);
        }

        return maxGain;
    }

    public static void main(String[] args) {
        int[] prices = {3, 5, 2, 6};
        int[] strategy = {-1, 0, 1, 1};

        System.out.println(baseProfit(prices, strategy)); // expected: 5
        System.out.println(profitAfterModification(prices, strategy, 2, 1)); // expected: 5
        System.out.println(calculateWindowGain(prices, strategy, 2, 1)); // expected: 0
        System.out.println(maxGainForWindowK(new int[]{4, 2, 8}, new int[]{-1, 0, 1}, 2));
    }
}
