class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int s = 0;
        
        for(int i=1; i<prices.length; i++) {
            if(prices[i]+1 == prices[i-1]) {
                continue;
            }
            ans+=(long)(i-s)*(i-s+1)/2;
            s = i;
        }
        ans+=(long)(prices.length-s)*(prices.length-s+1)/2;
        
        return ans;
    }
}