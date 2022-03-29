class Solution {
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        int pow = (int)(Math.log(k)/Math.log(10));
        int mod = 1000000007;
        dp[dp.length-1] = 1;
        for(int i=dp.length-2; i>=0; i--) {
            char c = s.charAt(i);
            if(c == '0') continue;
            
            if(c-'0' <= k) {
                dp[i]=(dp[i]+dp[i+1])%mod;
            }
            
            for(int j=i+1; j<Math.min(i+1+pow,s.length()); j++) {
                if(Integer.parseInt(s.substring(i,j+1)) <= k) {
                    dp[i]=(dp[i]+dp[j+1])%mod;
                }
            }
        }
        
        return dp[0];
    }
}