class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dir = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        double ans = 0;
        double[][] dp = new double[n][n];
        dp[row][column] = 1;
        int moves = k;
        
        for (; k>0; k--) {
            double[][] dp2 = new double[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if(dp[i][j] == 0) {
                        continue;
                    }
                    
                    for (int l=0; l<8; l++) {
                        int nRow = i+dir[l][0];
                        int nCol = j+dir[l][1];

                        if(nRow>=0 && nRow<n && nCol>=0 && nCol<n) {
                            dp2[nRow][nCol]+=dp[i][j]/8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans+=dp[i][j];
            }
        }

        return ans;
    }
}