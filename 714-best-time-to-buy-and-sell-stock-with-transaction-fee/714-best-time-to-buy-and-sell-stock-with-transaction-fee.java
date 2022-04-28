class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for(int i=1; i<prices.length; i++) {
            int curSell = buy+prices[i]-fee;
            int curBuy = sell-prices[i];
            sell = Math.max(sell, curSell);
            buy = Math.max(buy, curBuy);
            
        }
        return sell;
    }
}