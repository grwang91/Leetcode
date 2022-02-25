class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefix = new int[nums.length+1];
        int[][] dp = new int[nums.length][nums.length];
        int ans = 0;
        
        for(int i=1; i<=nums.length; i++) {
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        
        // dp[i][j] is maximum sum when firstLen starts at 'i', secondLen starts at 'j'
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(i==j || i>j && i<j+secondLen || i<j && j<firstLen+i ) continue;
                
                dp[i][j] = prefix[Math.min(prefix.length-1,i+firstLen)]-prefix[i]+prefix[Math.min(prefix.length-1,j+secondLen)]-prefix[j];
                ans = Math.max(ans,dp[i][j]);
            }
        }
        
        return ans;
    }
}