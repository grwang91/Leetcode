class Solution {
    public int longestSubarray(int[] nums) {
        int deleted = 0;
        int start = 0;
        int ans = 0;
        boolean isDeleted = false;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                deleted++;
            }
            
            while(deleted > 1) {
                if(nums[start++] == 0) {
                    deleted--;
                }
            }
            
            if(i-start+1 > ans) {
                isDeleted = deleted==0? false: true;
                ans = i-start+1;
            }
            // ans = Math.max(ans, i-start+1-deleted);
        }
        return ans-1;
    }
}