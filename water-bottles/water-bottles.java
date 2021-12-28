class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        
        do {
            numBottles+=empty/numExchange;
            empty%=numExchange;
            ans+=numBottles;
            empty+=numBottles;
            numBottles = 0;
        } while(empty >= numExchange);
        
        return ans;
    }
}