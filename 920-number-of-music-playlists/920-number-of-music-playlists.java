class Solution {
    int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];
        dp[0][0] = 1;
        
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                dp[i][j]+=dp[i-1][j]*Math.max(j-k,0);
                dp[i][j]+=dp[i-1][j-1]*(n-j+1);
                dp[i][j]%=mod;
            }
        }
        
        return (int)dp[goal][n];
    }
}