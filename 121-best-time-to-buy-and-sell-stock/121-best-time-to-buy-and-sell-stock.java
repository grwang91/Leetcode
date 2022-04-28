class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = 100001;
        for(int i=0; i<prices.length; i++) {
            ans = Math.max(ans, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        
        return ans;
    }
}