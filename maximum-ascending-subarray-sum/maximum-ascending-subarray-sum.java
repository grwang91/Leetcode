class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            
            if(i<nums.length-1 && nums[i] >= nums[i+1]) {
                ans = Math.max(ans,sum);
                sum = 0;
            }
        }
        ans = Math.max(ans,sum);
        
        return ans;
    }
}