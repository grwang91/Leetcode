class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if(rating[i] > rating[j]) {
                    ans+=dp[j];
                    dp[i]++;
                }
            }
        }
        
        Arrays.fill(dp, 0);
        for (int i=n-1; i>=0; i--) {
            for (int j=n-1; j>i; j--) {
                if(rating[i] > rating[j]) {
                    ans+=dp[j];
                    dp[i]++;
                }
            }
        }
        return ans;
    }
}