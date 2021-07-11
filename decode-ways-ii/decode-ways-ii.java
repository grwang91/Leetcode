class Solution {
    int ans = 0;
    int MOD = 1000000007;
    public int numDecodings(String s) {
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            char pre = s.charAt(i-1);
            if(c == '*') {
                dp[i+1] = (dp[i]*9)%MOD;
                if(pre == '1') {
                    dp[i+1] = (dp[i+1] + dp[i-1]*9)%MOD;
                } else if (pre == '2') {
                    dp[i+1] = (dp[i+1] + dp[i-1]*6)%MOD;
                } else if (pre == '*') {
                    dp[i+1] = (dp[i+1] + dp[i-1]*15)%MOD;
                }
            } else {
                dp[i+1] = c == '0' ? 0 : dp[i];
                if(pre == '1') {
                    dp[i+1] = (dp[i+1] + dp[i-1])%MOD;
                } else if (pre == '2' && c <= '6') {
                    dp[i+1] = (dp[i+1] + dp[i-1])%MOD;
                } else if (pre == '*' && c <= '6') {
                    dp[i+1] = (dp[i+1] + dp[i-1]*2)%MOD;
                } else if (pre == '*' && c >= '7') {
                    dp[i+1] = (dp[i+1] + dp[i-1])%MOD;
                }
            }
        }
        
        return (int)dp[s.length()];
    }
    

}