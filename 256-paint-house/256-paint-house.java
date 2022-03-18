class Solution {
    public int minCost(int[][] costs) {
        int[] dp = costs[0];
        
        for(int i=1; i<costs.length; i++) {
            int[] tmp = new int[3];
            tmp[0] = costs[i][0] + Math.min(dp[1],dp[2]);
            tmp[1] = costs[i][1] + Math.min(dp[0],dp[2]);
            tmp[2] = costs[i][2] + Math.min(dp[1],dp[0]);
            dp = tmp;
        }
        
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}