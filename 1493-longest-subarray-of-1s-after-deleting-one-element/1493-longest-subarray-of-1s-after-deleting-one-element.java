class Solution {
    public int longestSubarray(int[] nums) {
        int deleted = 0;
        int start = 0;
        int ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                deleted++;
            }
            
            while(deleted > 1) {
                if(nums[start++] == 0) {
                    deleted--;
                }
            }
            ans = Math.max(ans, i-start+1);
        }
        return ans-1;
    }
}