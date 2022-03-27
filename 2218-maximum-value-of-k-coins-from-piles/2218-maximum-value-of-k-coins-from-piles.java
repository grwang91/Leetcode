class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()+1][k+1];
        
        for(int i=1; i<=piles.size(); i++) {
            for(int j=1; j<=k; j++) {
                int sum = 0;
                int picked = 1;
                dp[i][j] = dp[i-1][j];
                for(int cur: piles.get(i-1)) {
                    if(j-picked < 0) {
                        break;
                    }
                    sum+=cur;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-picked]+sum);
                    picked++;
                }
                
            }
        }
        
        return dp[piles.size()][k];
    }
}