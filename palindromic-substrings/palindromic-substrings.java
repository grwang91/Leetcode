class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        boolean[][] dp = new boolean[n][n];
        
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        
        for (int i=n-1; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                
                if(j-i+1 == 2) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i+1][j-1];
                }
                
                if(dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}