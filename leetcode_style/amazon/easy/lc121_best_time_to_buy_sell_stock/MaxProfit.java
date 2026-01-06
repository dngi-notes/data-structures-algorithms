package amazon.easy.lc121_best_time_to_buy_sell_stock;

public class MaxProfit {
    /*
     * You are given an array 'prices' where 'prices[i]' is the price of a given
     * stock on the i_th day
     * 
     * You want to maximise your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock
     * 
     * Return the maximum profit you can achieve from this transaction. If you
     * cannot achieve any profit, return 0
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;

        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
    
    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        String output = "Output ";
        
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(output + mp.maxProfit(prices1)); // expected 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(output + mp.maxProfit(prices2)); // expected 0

        int[] prices3 = {};
        System.out.println(output + mp.maxProfit(prices3)); // expected 0

        int[] prices4 = null;
        System.out.println(output + mp.maxProfit(prices4)); // expected 0

        int[] prices5 = {7, 2, 1, 12, 5, 5, 6};
        System.out.println(output + mp.maxProfit(prices5)); // expected 11
    }
}
