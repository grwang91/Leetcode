class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int flip = 0;
        int start = 0;
        int ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                flip++;
            }
            
            while(flip > 1) {
                if(nums[start++] == 0) {
                    flip--;
                }
            }
            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}