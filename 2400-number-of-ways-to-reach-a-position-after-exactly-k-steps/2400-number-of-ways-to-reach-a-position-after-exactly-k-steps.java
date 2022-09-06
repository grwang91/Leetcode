class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int[] dp = new int[3000];
        int offset = 1000;
        int MOD = 1000000007;
        dp[startPos+offset] = 1;
        
        for(int i=0; i<k; i++) {
            int[] tmp = new int[3000];
            for(int j=0; j<tmp.length; j++) {
                if(j>0) {
                    tmp[j]=(dp[j-1]+tmp[j])%MOD;
                }
                if(j<tmp.length-1) {
                    tmp[j]=(dp[j+1]+tmp[j])%MOD;
                }
            }
            dp = tmp;
        }
        
        return dp[endPos+offset];
    }
}