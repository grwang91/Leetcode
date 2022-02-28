class Solution {
    public int splitArray(int[] nums, int m) {
        int[] prefix = new int[nums.length+1];
        int[][] dp = new int[m+1][nums.length];
        
        for(int i=1; i<=nums.length; i++) {
            prefix[i] = prefix[i-1]+nums[i-1];
        }
        
        for(int i=0; i<nums.length; i++) {
            dp[1][i] = prefix[nums.length]-prefix[i];
        }
        for(int i=2; i<=m; i++) {
            for(int j=nums.length-i; j>=0; j--) {
                int minSum = Integer.MAX_VALUE;
                for(int k=nums.length-(i-1); k>j; k--) {
                    int largestSum = Math.max(dp[i-1][k], prefix[k]-prefix[j]);
                    minSum = Math.min(largestSum, minSum);
                }
                dp[i][j] = minSum;
            }
        }
        
        return dp[m][0];
    }
}