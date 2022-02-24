class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long pos = nums[0];
        long neg = 0;
        long ans = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            long nextPos = Math.max(nums[i], neg+nums[i]);
            long nextNeg = pos-nums[i];
            pos = nextPos;
            neg = nextNeg;
            ans = Math.max(ans, Math.max(pos,neg));
        }
        
        return ans;
    }
}