class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(matrix[i][j] == '0')
                    continue;
                int a = i>0 && j>0 ? dp[i-1][j-1] : 0;
                int b = i>0 ? dp[i-1][j] : 0;
                int c = j>0 ? dp[i][j-1] : 0;
                
                dp[i][j] = Math.min(Math.min(a,b),c) + 1;
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}