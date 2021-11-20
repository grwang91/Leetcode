class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        
        dp[0][0] = 1;
        dp[0][2] = 1;
        
        for (int i=1; i<n; i++) {
            for (int j=0; j<3; j++) {
                if(obstacles[i]-1 == j) {
                    dp[i][j] = 1000000;
                    continue;
                }
                dp[i][j] = dp[i-1][j];
            }
            for (int j=0; j<3; j++) {
                if(obstacles[i]-1 == j) {
                    continue;
                }
                int a = j==0 ? dp[i][0] : dp[i][0]+1;
                int b = j==1 ? dp[i][1] : dp[i][1]+1;
                int c = j==2 ? dp[i][2] : dp[i][2]+1;
                
                dp[i][j] = Math.min(Math.min(a,b),c);
            }
        }
        
        return Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
    }
}