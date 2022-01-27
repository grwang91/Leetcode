class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m+1][n][n];
        
        for (int i=m-1; i>=0; i--) {
            for (int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    int max = 0;
                    for (int l=Math.max(0,j-1); l<=Math.min(n-1,j+1); l++) {
                        for (int o=Math.max(0,k-1); o<=Math.min(n-1,k+1); o++) {
                           max = Math.max(max, dp[i+1][l][o]); 
                        }
                    }
                    dp[i][j][k] = j==k? max+grid[i][j]: max+grid[i][j]+grid[i][k];
                }
            }
        }
        
        return dp[0][0][n-1];
    }
}