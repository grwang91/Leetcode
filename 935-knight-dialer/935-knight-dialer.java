class Solution {
    public int knightDialer(int n) {
        int mod = 1000000007;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        
        for(int i=1; i<n; i++) {
            int[] tmp = new int[10];
            tmp[0] = (dp[4]+dp[6])%mod;
            tmp[1] = (dp[6]+dp[8])%mod;
            tmp[2] = (dp[7]+dp[9])%mod;
            tmp[3] = (dp[4]+dp[8])%mod;
            tmp[4] = ((dp[3]+dp[9])%mod+dp[0])%mod;
            tmp[6] = ((dp[1]+dp[7])%mod+dp[0])%mod;
            tmp[7] = (dp[2]+dp[6])%mod;
            tmp[8] = (dp[1]+dp[3])%mod;
            tmp[9] = (dp[2]+dp[4])%mod;
            
            dp = tmp;
        }
        int ans = 0;
        
        for(int num : dp) {
            ans = (ans+num)%mod;
        }
        return ans;
    }
}