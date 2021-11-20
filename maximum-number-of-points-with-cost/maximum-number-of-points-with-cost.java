class Solution {
    public long maxPoints(int[][] points) {
        long[] dp = new long[points[0].length];
        long ans = 0;
        
        for (int i=1; i<=points.length; i++) {
            long[] left = new long[dp.length];
            long[] right = new long[dp.length];
            
            for (int j=0; j<dp.length; j++) {
                left[j] = j==0? dp[j]+points[i-1][j] : Math.max(left[j-1]-1-points[i-1][j-1]+points[i-1][j], dp[j]+points[i-1][j]);
            }
            for (int j=dp.length-1; j>=0; j--) {
                right[j] = j==dp.length-1? dp[j]+points[i-1][j] : Math.max(right[j+1]-1-points[i-1][j+1]+points[i-1][j], dp[j]+points[i-1][j]);
            }
            for (int j=0; j<dp.length; j++) {
                dp[j] = Math.max(left[j],right[j]);
            }
        }
        
        for (long num : dp) {
            ans = Math.max(ans,num);
        }
        return ans;
    }
}