class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int pre = nums[0];
        int cnt1 = 0;
        for(int i=1; i<nums.length; i++) {
            if(pre > nums[i]) {
                cnt1++;
            }
            pre = Math.max(pre,nums[i]);
        }
        
        int cnt2 = 0;
        pre = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] > pre) {
                cnt2++;
                pre = Math.min(pre,nums[i]);
            } else {
                pre = nums[i];
            }
            
        }
        
        return Math.min(cnt1, cnt2) < 2;
    }
}