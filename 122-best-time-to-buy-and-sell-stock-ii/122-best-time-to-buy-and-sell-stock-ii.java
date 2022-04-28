class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
            // 6
        int sell = 0;
        for(int i=1; i<prices.length; i++) {
            // -3
            int curBuy = sell-prices[i];
            // 6
            int curSell = prices[i]+buy;

            // 2, 0
            buy = Math.max(buy, curBuy);
            sell = Math.max(sell, curSell);
        }
        return sell;
    }
}