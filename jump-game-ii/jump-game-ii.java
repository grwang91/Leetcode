class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i=0; i<nums.length; i++) {
            for (int j=1; j<=nums[i]; j++) {
                if(i+j < dp.length) {
                    dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                }
            }
        }
        return dp[dp.length-1];
    }
}